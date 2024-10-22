def task1a(nums):
    '''
    nums -> vector int
    return -> vector int

    Dublati elementele care se divid cu 6, iar pe cele 
    care nu se divid, triplati-le folosind functionale
    '''

    result = []

    ################### TO DO #########################
    
    div6 = lambda x: x % 6 == 0
    double = lambda x : x * 2
    triple = lambda x : x * 3
    
    result = map(lambda x: double(x) if div6(x) else triple(x), nums)
    
    ###################################################

    # Nu modificati valoarea de retur a functiei
    return list(result)
