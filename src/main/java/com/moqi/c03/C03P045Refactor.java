package com.moqi.c03;

import com.moqi.bean.Album;
import com.moqi.bean.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@SuppressWarnings({"SimplifyStreamApiCallChains", "unused"})
public class C03P045Refactor {

    public interface LongTrackFinder {
        Set<String> findLongTracks(List<Album> albums);
    }

    /**
     * 遗留代码：找出长度大于 1 分钟的曲目
     */
    public static class Step0 implements LongTrackFinder {
        // BEGIN findLongTracks_0
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            for (Album album : albums) {
                for (Track track : album.getTrackList()) {
                    if (track.getLength() > 60) {
                        String name = track.getName();
                        trackNames.add(name);
                    }
                }
            }
            return trackNames;
        }
        // END findLongTracks_0
    }

    /**
     * 重构的第一步：找出长度大于 1 分钟的曲目
     */
    public static class Step1 implements LongTrackFinder {
        // BEGIN findLongTracks_1
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                .forEach(track -> {
                                    if (track.getLength() > 60) {
                                        String name = track.getName();
                                        trackNames.add(name);
                                    }
                                });
                    });
            return trackNames;
        }
        // END findLongTracks_1
    }

    /**
     * 重构的第二步：找出长度大于 1 分钟的曲目
     */
    public static class Step2 implements LongTrackFinder {
        // BEGIN findLongTracks_2
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                .filter(track -> track.getLength() > 60)
                                .map(Track::getName)
                                .forEach(trackNames::add);
                    });
            return trackNames;
        }
        // END findLongTracks_2
    }

    /**
     * 重构的第三步：找出长度大于 1 分钟的曲目
     */
    public static class Step3 implements LongTrackFinder {
        // BEGIN findLongTracks_3
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();

            albums.stream()
                    .flatMap(Album::getTracks)
                    .filter(track -> track.getLength() > 60)
                    .map(Track::getName)
                    .forEach(trackNames::add);

            return trackNames;
        }
        // END findLongTracks_3
    }

    /**
     * 重构的第四步：找出长度大于 1 分钟的曲目
     */
    public static class Step4 implements LongTrackFinder {
        // BEGIN findLongTracks_4
        @Override
        public Set<String> findLongTracks(List<Album> albums) {
            return albums.stream()
                    .flatMap(Album::getTracks)
                    .filter(track -> track.getLength() > 60)
                    .map(Track::getName)
                    .collect(toSet());
        }
        // END findLongTracks_4
    }

}
