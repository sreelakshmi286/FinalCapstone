import time

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.ie.webdriver import WebDriver
from Selenium_Func import find_element, click_element, verify_text, verify_user, click_Login, click_toggle


@pytest.fixture
def browser():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()


def test_saucedemo_scenario(browser):
    # Launch the URL
    browser.get("https://www.saucedemo.com/")
    # Verify SWAG LABS is present on the Web Page
    verify_text(browser, By.CLASS_NAME, "login_logo", "Swag Labs")
    # add user
    verify_user(browser, By.ID, "user-name", "standard_user")
    # enter password
    verify_user(browser, By.ID, "password", "secret_sauce")
    # click login
    click_Login(browser, By.ID, "login-button")
    # Add any one item to cart
    click_element(browser, By.CLASS_NAME, "btn_inventory")
    # Click on the right corner of the button and verify item is added to the cart

    time.sleep(2)
    # adding cart
    cart_item = find_element(browser, By.ID, "shopping_cart_container")
    assert cart_item.text == "1"  # Assuming the cart displays the count of items added
    time.sleep(2)
    cart_item.click()
    time.sleep(2)
    click_toggle(browser, By.ID, "react-burger-menu-btn")
    time.sleep(1)
    # Click on the left corner of the button and click on LOGOUT button
    logout_button = find_element(browser, By.ID, 'logout_sidebar_link')
    logout_button.click()

    time.sleep(10)

    if __name__ == "__main__":
        pytest.main()