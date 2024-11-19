import requests
from bs4 import BeautifulSoup

def student_function():
    url = "https://quotes.toscrape.com/"
    # HINT 1: Use requests to get the contents of the page and BeautifulSoup to navigate it.
    dict = {}
    return scrape_page(url, soup, dict)

def scrape_page(url, soup, dict):
    # TODO: Scrape the page!
    # HINT 2: Use the 'zip' function to go through the quotes list and the authors list at the same time.
    return dict