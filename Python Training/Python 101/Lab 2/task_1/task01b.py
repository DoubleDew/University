def task1b(phrase):
    '''
    phrase -> string
    return -> string

    Transformati in litere mari vocalele din fraza
    si salvati rezultatul in "new_phrase"
    '''

    new_phrase = ""

    ################### TO DO #########################
    
    consoana = lambda x: x if x not in "aeiou" else x.upper()
    new_phrase = map(consoana, phrase)

    ###################################################

    # Nu modificati valoarea de retur a functiei
    return ''.join(list(new_phrase))
