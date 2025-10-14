import requests as request
from bs4 import BeautifulSoup

def student_function():
    url = "https://quotes.toscrape.com/"
    r = request.get(url)
    soup = BeautifulSoup(r.content, 'html.parser')
    dict = {}
    return scrape_page(url, soup, dict)

def scrape_page(url, soup, dict):
    
    author = soup.find_all(itemprop = 'author')
    quote = soup.find_all(itemprop = 'text')
    
    for i, j in zip(author, quote):
        authors = i.text.strip()
        quotes = j.text.strip()
        quotes = quotes.replace("“", "").replace("”", "").strip()
                                
        if authors not in dict:
            dict[authors] = []
            
        dict[authors].append(quotes)
    
    return dict