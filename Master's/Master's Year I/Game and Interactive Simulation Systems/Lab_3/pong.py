import pygame

pygame.init()

font20 = pygame.font.SysFont("Arial", 20)

BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
GREEN = (0, 255, 0)

WIDTH, HEIGHT = 900, 600
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Pong")

clock = pygame.time.Clock()
FPS = 60

class Striker: 
    def __init__ (self, posx, posy, width, height, speed, color):
        self.posx = posx
        self.posy = posy
        self.width = width
        self.height = height
        self.speed = speed
        self.color = color
        
        self.geekRect = pygame.Rect(self.posx, self.posy, self.width, self.height)

        self.geek = pygame.draw.rect(screen, self.color, self.geekRect)
        
    def display(self):
        self.geek = pygame.draw.rect(screen, self.color, self.geekRect)
        
    def update(self, yFac):
        self.posy = self.posy + self.speed * yFac

        if self.posy <= 0:
            self.posy = 0
        
        elif self.posy + self.height >= HEIGHT:
            self.posy = HEIGHT - self.height