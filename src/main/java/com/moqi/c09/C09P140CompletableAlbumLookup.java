package com.moqi.c09;

import com.moqi.bean.Album;
import com.moqi.bean.Artist;
import com.moqi.bean.Track;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class C09P140CompletableAlbumLookup implements C09P140AlbumLookup {

    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(4);

    private final List<Track> tracks;
    private final List<Artist> artists;
    // Variables Exists to satisfy code sample below
    private Track track;
    private Artist artist;


    public C09P140CompletableAlbumLookup(List<Track> tracks, List<Artist> artists) {
        this.tracks = tracks;
        this.artists = artists;
    }

    /**
     * 使用 CompletableFuture 从外部网站下载专辑信息
     */
    // BEGIN lookupByName
    public Album lookupByName(String albumName) {
        CompletableFuture<List<Artist>> artistLookup
                = loginTo("artist")
                .thenCompose(artistLogin -> lookupArtists(albumName, artistLogin));  // <1>

        return loginTo("track")
                .thenCompose(trackLogin -> lookupTracks(albumName, trackLogin)) // <2>
                .thenCombine(artistLookup, (tracks, artists)
                        -> new Album(albumName, tracks, artists)) // <3>
                .join(); // <4>
    }
    // END lookupByName

    /**
     * 异步创建 CompletableFuture 实例的示例代码
     */
    // BEGIN lookupTrack
    CompletableFuture<Track> lookupTrack(String id) {
        return CompletableFuture.supplyAsync(() -> {
            // Some expensive work is done here <1>
            // 这里会做一些繁重的工作
            // ...
            return track; // <2>
        }, SERVICE); // <3>
    }
    // END lookupTrack

    /**
     * 为 Future 提供值
     */
    // BEGIN createFuture
    CompletableFuture<Artist> createFuture(String id) {
        CompletableFuture<Artist> future = new CompletableFuture<>();
        startJob(future);
        return future;
    }
    // END createFuture

    /**
     * 为 Future 提供一个值，完成工作
     */
    private void startJob(CompletableFuture<Artist> future) {
        // BEGIN complete
        future.complete(artist);
        // END complete
    }

    /**
     * 出现错误时完成 Future
     */
    private void processExceptionally(CompletableFuture<Album> future, String name) {
        // BEGIN completeExceptionally
        future.completeExceptionally(new C09P140AlbumLookupException("Unable to find " + name));
        // END completeExceptionally
    }

    // ----------------- FAKE LOOKUP METHODS -----------------
    //         Represent API lookup on external services

    private CompletableFuture<List<Artist>> lookupArtists(String albumName, C09P140Credentials credentials) {
        return CompletableFuture.completedFuture(artists);
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private CompletableFuture<List<Track>> lookupTracks(String albumName, C09P140Credentials credentials) {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return tracks;
        }, SERVICE);
    }

    private CompletableFuture<C09P140Credentials> loginTo(String serviceName) {
        return CompletableFuture.supplyAsync(() -> {
            if ("artist".equals(serviceName)) {
                sleep(1000);
            }
            return new C09P140Credentials();
        }, SERVICE);
    }

}
