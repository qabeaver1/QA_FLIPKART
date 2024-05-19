package demo;

public class MapInputs {

    private String title;
    private String imgUrl;
    private int reviewCount;

    public MapInputs(String title, String imgUrl, int reviewCount) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.reviewCount = reviewCount;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getReviewCount() {
        return reviewCount;
    }

}
