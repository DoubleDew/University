import numpy as np

class Image():
    def __init__(self, format='P3', rows=0, columns=0, max_value=255, pixels=[[]]):
        self.format = format
        self.rows = rows
        self.columns = columns
        self.max_value = max_value
        self.pixels = pixels
    
    def __str__(self):    
        image = ""
        image += f"{self.format}{self.rows} {self.columns}\n{self.max_value}\n"
        for i in range(self.rows):
            for j in range(3 * self.columns):
                image += f"{self.pixels[i][j]} "
            image += "\n"
        return image
    
    def sepia(self):

        pass
    
    def read(self, filename):
        f = open(filename, "r")
       
        format_line = f.readline().strip()
        if format_line != "P3":
            print("Unsupported format!")
            return None
        
        dimensions = f.readline().strip()
        if len(dimensions.split()) != 2 or not all(d.isdigit() for d in dimensions.split()):
            print("Invalid dimensions in PPM header!")
            return None
        N, M = map(int, dimensions.split())
        
        max_values_line = f.readline().strip()
        if not max_values_line.isdigit() or int(max_values_line) != 255:
            print("Invalid max value in PPM header!")
            return None
        
        body = f.read().split()
        pixels = list(map(int, body))
        expected = N * M * 3
        if len(pixels) != expected:
            print(f"Invalid number of pixels in body! Expected {expected}, got {len(pixels)}")
            return None
        
        rows = [
            np.array(pixels[i * M * 3 : (i + 1) * M * 3], dtype = int).reshape(M, 3)
            for i in range(N)
        ]
        
        image = np.vstack(rows)
        
        return image
                
    def write(self, filename):
        
        pass
