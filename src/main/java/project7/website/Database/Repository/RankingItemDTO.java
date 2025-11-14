package project7.website.Database.Repository;

import lombok.Data;

import java.util.Objects;

public final class RankingItemDTO {
    private final String img;
    private final String name;
    private final String brand;
    private final String price;

    public RankingItemDTO(String img, String name, String brand, String price) {
        this.img = img;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String img() {
        return img;
    }

    public String name() {
        return name;
    }

    public String brand() {
        return brand;
    }

    public String price() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RankingItemDTO) obj;
        return Objects.equals(this.img, that.img) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.brand, that.brand) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img, name, brand, price);
    }

    @Override
    public String toString() {
        return "RankingItemDTO[" +
                "img=" + img + ", " +
                "name=" + name + ", " +
                "brand=" + brand + ", " +
                "price=" + price + ']';
    }

}
