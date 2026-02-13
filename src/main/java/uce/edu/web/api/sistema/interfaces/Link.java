package uce.edu.web.api.sistema.interfaces;

public class Link {
    public String rel;
    public String href;

    public Link() {
    }

    public Link(String rel, String href) {
        this.rel = rel;
        this.href = href;
    }
}
