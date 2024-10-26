package com.example.testtaskagencyamazon.data;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SPCampaignStatisticTest {

    @Test
    public void testConstructor() {
        SPCampaignReport report = new SPCampaignReport();
        report.setProfileId(1L);
        report.setPortfolioId("2");
        report.setDate("2024-10-26");
        report.setCampaignId(3L);
        report.setCampaignName("Test Campaign");
        report.setCampaignStatus("ACTIVE");
        report.setClicks(10);
        report.setSpend(BigDecimal.valueOf(100));
        report.setImpressions(1000);
        report.setSales14d(BigDecimal.valueOf(500));
        report.setPurchases14d(5);
        report.setPurchasesSameSku14d(2);

        SPCampaignStatistic statistic = new SPCampaignStatistic(report);

        assertEquals(1L, statistic.getProfileId());
        assertEquals(Long.valueOf(2), statistic.getPortfolioId());
        assertEquals("2024-10-26", statistic.getDate());
        assertEquals(3L, statistic.getCampaignId());
        assertEquals("Test Campaign", statistic.getCampaignName());
        assertEquals("ACTIVE", statistic.getState());
        assertEquals(10, statistic.getClicks());
        assertEquals(BigDecimal.valueOf(100), statistic.getCost());
        assertEquals(1000, statistic.getImpressions());
        assertEquals(BigDecimal.valueOf(500), statistic.getSales());
        assertEquals(5, statistic.getPurchases());
        assertEquals(2, statistic.getPurchasesSameSku());
    }

    @Test
    public void testAdd() {
        SPCampaignReport report1 = new SPCampaignReport();
        report1.setProfileId(1L);
        report1.setPortfolioId("2");
        report1.setDate("2024-10-26");
        report1.setCampaignId(3L);
        report1.setCampaignName("Test Campaign 1");
        report1.setCampaignStatus("ACTIVE");
        report1.setClicks(10);
        report1.setSpend(BigDecimal.valueOf(100));
        report1.setImpressions(1000);
        report1.setSales14d(BigDecimal.valueOf(500));
        report1.setPurchases14d(5);
        report1.setPurchasesSameSku14d(2);

        SPCampaignStatistic statistic1 = new SPCampaignStatistic(report1);

        SPCampaignReport report2 = new SPCampaignReport();
        report2.setProfileId(1L);
        report2.setPortfolioId("2");
        report2.setDate("2024-10-26");
        report2.setCampaignId(3L);
        report2.setCampaignName("Test Campaign 2");
        report2.setCampaignStatus("ACTIVE");
        report2.setClicks(15);
        report2.setSpend(BigDecimal.valueOf(150));
        report2.setImpressions(1500);
        report2.setSales14d(BigDecimal.valueOf(700));
        report2.setPurchases14d(7);
        report2.setPurchasesSameSku14d(3);

        SPCampaignStatistic statistic2 = new SPCampaignStatistic(report2);

        statistic1.add(statistic2);

        assertEquals(25, statistic1.getClicks());
        assertEquals(BigDecimal.valueOf(250).setScale(2, BigDecimal.ROUND_HALF_UP), statistic1.getCost());
        assertEquals(2500, statistic1.getImpressions());
        assertEquals(BigDecimal.valueOf(1200).setScale(2, BigDecimal.ROUND_HALF_UP), statistic1.getSales());
        assertEquals(12, statistic1.getPurchases());
        assertEquals(5, statistic1.getPurchasesSameSku());
    }

    @Test
    public void testFinalise() {
        SPCampaignReport report = new SPCampaignReport();
        report.setProfileId(1L);
        report.setPortfolioId("2");
        report.setDate("2024-10-26");
        report.setCampaignId(3L);
        report.setCampaignName("Test Campaign");
        report.setCampaignStatus("ACTIVE");
        report.setClicks(10);
        report.setSpend(BigDecimal.valueOf(100));
        report.setImpressions(1000);
        report.setSales14d(BigDecimal.valueOf(500));
        report.setPurchases14d(5);
        report.setPurchasesSameSku14d(2);

        SPCampaignStatistic statistic = new SPCampaignStatistic(report);
        statistic.add(statistic); // добавляем саму себя для теста
        statistic.finalise();

        assertEquals(BigDecimal.valueOf(500).setScale(2, BigDecimal.ROUND_HALF_UP), statistic.getSales());
        assertEquals(BigDecimal.valueOf(100).setScale(2, BigDecimal.ROUND_HALF_UP), statistic.getCost());
    }

    @Test
    public void testCreateEmptyStatistic() {
        SPCampaignStatistic statistic = SPCampaignStatistic.createEmptyStatistic(1L, 2L, "2024-10-26", 3L, "Test Campaign", "ACTIVE");

        assertEquals(1L, statistic.getProfileId());
        assertEquals(Long.valueOf(2), statistic.getPortfolioId());
        assertEquals("2024-10-26", statistic.getDate());
        assertEquals(3L, statistic.getCampaignId());
        assertEquals("Test Campaign", statistic.getCampaignName());
        assertEquals("ACTIVE", statistic.getState());
        assertEquals(0, statistic.getClicks());
        assertEquals(BigDecimal.ZERO, statistic.getCost());
        assertEquals(0, statistic.getImpressions());
        assertEquals(BigDecimal.ZERO, statistic.getSales());
        assertEquals(0, statistic.getPurchases());
        assertEquals(0, statistic.getPurchasesSameSku());
    }
}