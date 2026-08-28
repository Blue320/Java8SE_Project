package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

    // 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    // 1. 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPriceMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceMap.put(type, totalPriceMap.getOrDefault(type, 0) + pub.getPrice());
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averageMap = new HashMap<>();
        for (String type : totalPriceMap.keySet()) {
            double avg = (double) totalPriceMap.get(type) / countMap.get(type);
            averageMap.put(type, avg);
        }
        return averageMap;
    }

    // 2. 출판물 유형 분포 계산 (백분율)
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countMap = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countMap.put(type, countMap.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distributionMap = new HashMap<>();
        for (String type : countMap.keySet()) {
            double percent = ((double) countMap.get(type) / publications.length) * 100.0;
            distributionMap.put(type, percent);
        }
        return distributionMap;
    }

    // 3. 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate() != null && pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        return ((double) count / publications.length) * 100.0;
    }

    // 4. 통계 정보 출력 메서드
    public void printStatistics(Publication[] publications) {
        DecimalFormat priceFormat = new DecimalFormat("#,###원");
        DecimalFormat percentFormat = new DecimalFormat("0.00'%'");

        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        double yearRatio = calculatePublicationRatioByYear(publications, "2007");

        System.out.println("====출판물 통계 분석====");
        
        System.out.println("1. 타입별 평균 가격:");
        if (avgPrices.containsKey("소설")) {
            System.out.println("- 소설: " + priceFormat.format(Math.round(avgPrices.get("소설"))));
        }
        if (avgPrices.containsKey("참고서")) {
            System.out.println("- 참고서: " + priceFormat.format(Math.round(avgPrices.get("참고서"))));
        }
        if (avgPrices.containsKey("잡지")) {
            System.out.println("- 잡지: " + priceFormat.format(Math.round(avgPrices.get("잡지"))));
        }

        System.out.println("2. 출판물 유형 분포:");
        if (distribution.containsKey("소설")) {
            System.out.println("- 소설: " + percentFormat.format(distribution.get("소설")));
        }
        if (distribution.containsKey("참고서")) {
            System.out.println("- 참고서: " + percentFormat.format(distribution.get("참고서")));
        }
        if (distribution.containsKey("잡지")) {
            System.out.println("- 잡지: " + percentFormat.format(distribution.get("잡지")));
        }

        System.out.println("3. 2007년에 출판된 출판물 비율: " + percentFormat.format(yearRatio));
    }
}