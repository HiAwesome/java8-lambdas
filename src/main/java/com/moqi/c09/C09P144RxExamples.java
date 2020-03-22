package com.moqi.c09;

import com.moqi.bean.Artist;
import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.List;

import static java.util.stream.Collectors.toList;

@SuppressWarnings("ALL")
public class C09P144RxExamples {

    private final List<Artist> savedArtists;
    private final List<String> savedArtistNames;

    public C09P144RxExamples(List<Artist> savedArtists) {
        this.savedArtists = savedArtists;
        savedArtistNames = savedArtists.stream()
                .map(Artist::getName)
                .collect(toList());
    }

    /**
     * 通过名字和国籍查找艺术家通过名字和国籍查找艺术家
     */
    // BEGIN search
    public Observable<Artist> search(String searchedName,
                                     String searchedNationality,
                                     int maxResults) {

        return getSavedArtists()  // <1>
                .filter(name -> name.contains(searchedName)) // <2>
                .flatMap(this::lookupArtist) // <3>
                .filter(artist -> artist.getNationality() // <4>
                        .contains(searchedNationality))
                .take(maxResults); // <5>
    }
    // END search

    //  ------------------ FAKE LOOKUP CODE ------------------
    //          Again, imaginary external web services

    private Observable<String> getSavedArtists() {
        return Observable.fromIterable(savedArtistNames);
    }

    private Observable<Artist> lookupArtist(String name) {
        Artist required = savedArtists.stream()
                .filter(artist -> artist.getName().equals(name))
                .findFirst()
                .get();

        return Observable.fromArray(required);
    }

    // Purely for imported code sample
    public void creationCodeSample() {
        Observer<String> observer = null;

        // BEGIN completing_observable
        observer.onNext("a");
        observer.onNext("b");
        observer.onNext("c");
        observer.onComplete();
        // END completing_observable

        // BEGIN error_observable
        observer.onError(new Exception());
        // END error_observable

    }

}
