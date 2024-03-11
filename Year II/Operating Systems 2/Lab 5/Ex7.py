def e7(readFileName writeFileName)

readFile = open(readFileName)
writeFile = open(writeFileName, mode = "rw")
    
string = readFile.read()
    
writeFile.write(string.upper())
    
readFile.close()
writeFile.close()