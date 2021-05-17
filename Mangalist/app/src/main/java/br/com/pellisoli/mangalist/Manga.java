package br.com.pellisoli.mangalist;

public class Manga {

    private int id;

    private String titulo;

    private String linkImg;

    private String linkTitulo;

    private int ultimoCap = 0;


    public Manga() {
    }

    public Manga(int id, String titulo, String linkImg, String linkTitulo, int ultimoCap) {
        this.id = id;
        this.titulo = titulo;
        this.linkImg = linkImg;
        this.linkTitulo = linkTitulo;
        this.ultimoCap = ultimoCap;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }

    public String getLinkTitulo() {
        return linkTitulo;
    }

    public void setLinkTitulo(String linkTitulo) {
        this.linkTitulo = linkTitulo;
    }

    public int getUltimoCap() {
        return ultimoCap;
    }

    public void setUltimoCap(int ultimoCap) {
        this.ultimoCap = ultimoCap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
