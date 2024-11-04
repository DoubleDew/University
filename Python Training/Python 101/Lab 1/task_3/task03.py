
def func(string_message):
    """ 
    Puneti rezultatul codificarii mesajului in "encoded_message"

    HINT!
    chr() si ord() sunt functii implicite care "jongleaza" cu caracterele
    ASCII si codificarile lor. Astfel, daca pentru litera 'A', avem codificarea
    65, iar pentru 'B' avem 66, atunci:
    
    chr(65) = 'A'   ||   chr(66) = 'B'  
    ord('A') = 65   ||   ord('B') = 66

    ANOTHER HINT!
    Poti folosi dictionarele.
    """
    
    encoded_message = ""
    ################### TO DO #########################

    # smart way
    alphabet = {' ': '0'}
    for i in range(65, 91):
        alphabet[chr(i)] = str(i - 64)
        
    for i in string_message:
        encoded_message += alphabet[i]

    # dumb way (not stupid if it works)
    # alphabet = {
    #     ' ': '0',
    #     'A': '1',
    #     'B': '2',
    #     'C': '3',
    #     'D': '4',
    #     'E': '5',
    #     'F': '6',
    #     'G': '7',
    #     'H': '8',
    #     'I': '9',
    #     'J': '10',
    #     'K': '11',
    #     'L': '12',
    #     'M': '13',
    #     'N': '14',
    #     'O': '15',
    #     'P': '16',
    #     'Q': '17',
    #     'R': '18',
    #     'S': '19',
    #     'T': '20',
    #     'U': '21',
    #     'V': '22',
    #     'W': '23',
    #     'X': '24',
    #     'Y': '25',
    #     'Z': '26'
    # }
    
    # for i in string_message:
    #     encoded_message += alphabet[i]

    ###################################################

    return encoded_message