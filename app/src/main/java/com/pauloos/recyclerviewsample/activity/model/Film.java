package com.pauloos.recyclerviewsample.activity.model;

/** 12 **/
public class Film {

    private String title, releaseDate, order, chronologicalYear, overview, director, writer, runtime, youtubeId;
    private int posterUrl, idMcu, idRel;
    private boolean seen;

    public Film() {
    }

    public Film(String title, String releaseDate, String order, String chronologicalYear, String overview, String director, String writer, String runtime, int posterUrl, int idMcu, int idRel, boolean seen, String youtubeId) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.order = order;
        this.chronologicalYear = chronologicalYear;
        this.overview = overview;
        this.director = director;
        this.writer = writer;
        this.runtime = runtime;
        this.posterUrl = posterUrl;
        this.idMcu = idMcu;
        this.idRel = idRel;
        this.seen = seen;
        this.youtubeId = youtubeId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    public String getChronologicalYear() {
        return chronologicalYear;
    }
    public void setChronologicalYear(String chronologicalYear) {
        this.chronologicalYear = chronologicalYear;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    public int getPosterUrl() {
        return posterUrl;
    }
    public void setPosterUrl(int posterUrl) {
        this.posterUrl = posterUrl;
    }
    public int getIdMcu() {
        return idMcu;
    }
    public void setIdMcu(int idMcu) {
        this.idMcu = idMcu;
    }
    public int getIdRel() {
        return idRel;
    }
    public void setIdRel(int idRel) {
        this.idRel = idRel;
    }
    public boolean isSeen() {
        return seen;
    }
    public void setSeen(boolean seen) {
        this.seen = seen;
    }
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
    public String getRuntime() {
        return runtime;
    }
    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }
    public String getYoutubeId() {
        return youtubeId;
    }
}
