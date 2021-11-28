package programmers.three;

import java.util.*;

/** 베스트 앨범
 * 장르별로 가장 많이 재생된 노래를 두개씩 모아 베스트 앨범을 출시하려 한다.
 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 아래와 같다.
 *
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록한다.
 * 2. 장르내에서 많이 재생된 노래를 먼저 수록한다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록
 *
 * 매개변수
 * genres = 노래의 장르를 나타내는 문자열 배열
 * plays = 노래별 재생 횟수를 나타내는 정수 배열
 *
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
 *
 * */

public class BestAlbum {
    class Genre{
        private String name;
        private int cumulativePlay;
        private List<Song> songs;

        Genre(String name){
            this.name = name;
            songs = new ArrayList();
        }

        private void setCumulativePlay(int play){
            this.cumulativePlay += play;
        }

        private void setSongs(Song song){
            this.songs.add(song);
        }

        private int getCumulativePlay(){
            return this.cumulativePlay;
        }

        private void setBestSongs(List<Song> song){
            int cnt = 0;
            Collections.sort(songs);
            for(Song s : songs){
                if(cnt == 2){
                    break;
                }
                song.add(s);
                cnt++;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if(this.name.equals(obj)){
                return true;
            }
            return false;
        }
    }

    class Song implements Comparable<Song>{
        private int id;
        private int play;

        Song(int id, int play){
            this.id = id;
            this.play = play;
        }

        private int getId(){
            return this.id;
        }

        private int getPlay(){
            return this.play;
        }

        @Override
        public int compareTo(Song o) {
            if(this.getPlay() < o.getPlay()){
                return 1;
            }else if(this.getPlay() == o.getPlay()){
                if(this.getId() > o.getId()){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return - 1;
            }
        }
    }

    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 500, 150, 800, 2500};
        new BestAlbum().solution(genres, plays);
    }

    public int[] solution(String[] genres, int[] plays){
        Set<Genre> genreList = new HashSet<>();

        for(int i = 0; i < genres.length; i++){
            String genreName = genres[i];
            Genre genre = genreList.stream()
                    .filter(x -> x.equals(genreName))
                    .findAny()
                    .orElse(new Genre(genreName));
            genre.setCumulativePlay(plays[i]);
            genre.setSongs(new Song(i, plays[i]));
            genreList.add(genre);
        }

        List<Song> bestAlbum = new ArrayList<>();

        genreList.stream()
                .sorted(new Comparator<Genre>(){
                    @Override
                    public int compare(Genre o1, Genre o2) {
                        if(o1.getCumulativePlay() < o2.getCumulativePlay()){
                            return 1;
                        }
                        return -1;
                    }
                })
                .forEach(x -> x.setBestSongs(bestAlbum));

        int[] answer = new int[bestAlbum.size()];
        for(int i = 0; i < bestAlbum.size(); i++){
            answer[i] = bestAlbum.get(i).getId();
        }

        return answer;
    }
}

