package tests;

import helpers.TestData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import tests.setup.BaseTest;

public class IngredientsTabsTests extends BaseTest {
    private String activeTabIdentifier = TestData.returnActiveTabIdentifier();

    @Test
    @DisplayName("Navigate Buns tab test")
    public void navigateBunsTest() {
        //опытным путём было выяснено, что только после перехода на вкладку с соусами остальное отрабатывает корректно,
        //если все тесты запускать, а не по одному
        homePage.goToSaucesTab();
        homePage.goToBunsTab();
        String classBuns = homePage.getClassBunsTab();
        Assert.assertTrue("ActiveTabIdentifier should be present", classBuns.contains(activeTabIdentifier));
    }

    @Test
    @DisplayName("Navigate Sauces tab test")
    public void navigateSaucesTab() {
        homePage.goToSaucesTab();
        String classSauce = homePage.getClassSauceTab();
        Assert.assertTrue("ActiveTabIdentifier should be present", classSauce.contains(activeTabIdentifier));
    }

    @Test
    @DisplayName("Navigate Fillings tab test")
    public void navigateFillingsTab() {
        homePage.goToSaucesTab();
        homePage.goToFillingsTab();
        String classFillings = homePage.getClassFillingsTab();
        Assert.assertTrue("ActiveTabIdentifier should be present", classFillings.contains(activeTabIdentifier));
    }
}
