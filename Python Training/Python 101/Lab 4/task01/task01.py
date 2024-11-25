import random as rd
import math

def random_points(radius, x_center, y_center):
    angle = rd.uniform(0, 2 * math.pi)
    
    r = math.sqrt(rd.uniform(0, 1)) * radius
    
    x = r * math.cos(angle) + x_center
    y = r * math.sin(angle) + y_center
    
    return x, y
