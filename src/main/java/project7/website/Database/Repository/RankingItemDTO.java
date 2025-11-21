package project7.website.Database.Repository;

/**
 * 랭킹 페이지 상품
 * 구현체 : {@link RankingItemRepository}
 *
 * @param img 이미지 URL
 * @param url 올라인 몰 URL
 * @param name 상품 이름
 * @param brand 브랜드
 * @param price 가격
 */
public record RankingItemDTO(String img, String url,String name, String brand, String price) {
}
