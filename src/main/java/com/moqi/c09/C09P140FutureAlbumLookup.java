package com.moqi.c09;

import com.moqi.bean.Album;
import com.moqi.bean.Artist;
import com.moqi.bean.Track;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C09P140FutureAlbumLookup implements C09P140AlbumLookup {

    private static final ExecutorService service = Executors.newFixedThreadPool(2);

    private final List<Track> tracks;
    private final List<Artist> artists;

    public C09P140FutureAlbumLookup(List<Track> tracks, List<Artist> artists) {
        this.tracks = tracks;
        this.artists = artists;
    }

    /**
     * 使用 Future 从外部网站下载专辑信息
     */
    // BEGIN lookupByName
    @Override
    public Album lookupByName(String albumName) {
        Future<C09P140Credentials> trackLogin = loginTo("track"); // <1>
        Future<C09P140Credentials> artistLogin = loginTo("artist");

        try {
            Future<List<Track>> tracks = lookupTracks(albumName, trackLogin.get()); // <2>
            Future<List<Artist>> artists = lookupArtists(albumName, artistLogin.get());

            return new Album(albumName, tracks.get(), artists.get()); // <3>
        } catch (InterruptedException | ExecutionException e) {
            throw new C09P140AlbumLookupException(e.getCause()); // <4>
        }
    }
    // END lookupByName

    // ----------------- FAKE LOOKUP METHODS -----------------
    //         Represent API lookup on external services

    private Future<List<Artist>> lookupArtists(String albumName, C09P140Credentials credentials) {
        return service.submit(() -> {
            fakeWaitingForExternalWebService();
            return artists;
        });
    }

    private Future<List<Track>> lookupTracks(String albumName, C09P140Credentials credentials) {
        return service.submit(() -> tracks);
    }

    private Future<C09P140Credentials> loginTo(String serviceName) {
        return service.submit(() -> {
            if ("track".equals(serviceName)) {
                fakeWaitingForExternalWebService();
            }
            return new C09P140Credentials();
        });
    }

    private void fakeWaitingForExternalWebService() throws InterruptedException {
        Thread.sleep(1000);
    }

}
