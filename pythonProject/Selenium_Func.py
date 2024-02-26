from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

def find_element(driver, by, locator):
    return WebDriverWait(driver, 10).until(EC.presence_of_element_located((by, locator)))


def click_element(driver, by, locator):
    element = find_element(driver, by, locator)
    element.click()


def verify_user(driver, by, locator, enter_user):
    element = find_element(driver, by, locator)
    element.send_keys(enter_user)


def verify_password(driver, by, locator, enter_password):
    element = find_element(driver, by, locator)
    element.send_keys(enter_password)


def click_Login(driver, by, locator):
    element = find_element(driver, by, locator)
    element.click()


def click_toggle(driver, by, locator):
    element = find_element(driver, by, locator)
    element.click()


def verify_text(driver, by, locator, expected_text):
    element = find_element(driver, by, locator)
    assert element.text == expected_text


def click_element(driver, by, locator):
    element = find_element(driver, by, locator)
    element.click()


def click_addtocart(driver, by, locator):
    element = find_element(driver, by, locator)
    element.click()