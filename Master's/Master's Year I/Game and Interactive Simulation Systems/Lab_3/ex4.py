# ...existing code...
import pygame
import os
import sys

BASE_DIR = '/home/danutz/Desktop/GitHub/University/Master\'s/Master\'s Year I/Game and Interactive Simulation Systems/Lab_3'
img_path = os.path.join(BASE_DIR, 'Grimm_Idle.png')
hit_sound_filename = 'Bonk Sound Effect.mp3'

class Grimm(object):
    def __init__(self):
        SCALE = 0.5
        loaded = pygame.image.load(img_path).convert_alpha()
        w, h = loaded.get_width(), loaded.get_height()
        self.orig_image = pygame.transform.scale(loaded, (int(w * SCALE), int(h * SCALE)))
        self.flipped_image = pygame.transform.flip(self.orig_image, True, False)
        self.facing_right = True

        self.x = 0
        self.y = 0

        self.hit_sound = None
        self._clamped_x_prev = False
        self._clamped_y_prev = False

    def handle_keys(self):
        key = pygame.key.get_pressed()
        dist = 5
        if key[pygame.K_LEFT]:
            self.x -= dist
            self.facing_right = False
        if key[pygame.K_RIGHT]:
            self.x += dist
            self.facing_right = True
        if key[pygame.K_UP]:
            self.y -= dist
        if key[pygame.K_DOWN]:
            self.y += dist

        surf = pygame.display.get_surface()
        if surf:
            sw, sh = surf.get_size()
            max_x = sw - self.orig_image.get_width()
            max_y = sh - self.orig_image.get_height()

            prev_x = self.x
            prev_y = self.y

            self.x = max(0, min(self.x, max_x))
            self.y = max(0, min(self.y, max_y))

            clamped_x = (self.x == 0) or (self.x == max_x)
            clamped_y = (self.y == 0) or (self.y == max_y)

            if (clamped_x and not self._clamped_x_prev) or (clamped_y and not self._clamped_y_prev):
                if self.hit_sound:
                    try:
                        self.hit_sound.play()
                    except Exception:
                        pass

            self._clamped_x_prev = clamped_x
            self._clamped_y_prev = clamped_y

    def draw(self, surface):
        img = self.orig_image if self.facing_right else self.flipped_image
        surface.blit(img, (self.x, self.y))

    def get_draw_image(self):
        return self.orig_image if self.facing_right else self.flipped_image


pygame.init()
try:
    pygame.mixer.init()
except Exception:
    pass

screen = pygame.display.set_mode((800, 800))
pygame.display.set_caption("Grimm")

# load hit sound (optional)
hit_sound_path = os.path.join(BASE_DIR, hit_sound_filename)
try:
    hit_sound = pygame.mixer.Sound(hit_sound_path)
except Exception:
    hit_sound = None  # fine if file missing or unsupported

grimm = Grimm()
grimm.hit_sound = hit_sound  # assign sound to sprite

grimm.x = screen.get_width() // 2 - grimm.orig_image.get_width() // 2
grimm.y = screen.get_height() // 2 - grimm.orig_image.get_height() // 2

clock = pygame.time.Clock()
font = pygame.font.SysFont(None, 24)

running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        elif event.type == pygame.KEYDOWN and event.key == pygame.K_ESCAPE:
            running = False

    grimm.handle_keys()

    screen.fill((255, 255, 255))

    grimm.draw(screen)

    coord_text = f"X: {grimm.x}  Y: {grimm.y}"
    coord_surf = font.render(coord_text, True, (0, 0, 0))
    coord_rect = coord_surf.get_rect()
    draw_img = grimm.get_draw_image()
    coord_rect.centerx = grimm.x + draw_img.get_width() // 2
    coord_rect.bottom = grimm.y - 6 

    if coord_rect.left < 4:
        coord_rect.left = 4
    if coord_rect.right > screen.get_width() - 4:
        coord_rect.right = screen.get_width() - 4
    if coord_rect.top < 4:
        coord_rect.top = 4

    screen.blit(coord_surf, coord_rect)

    pygame.display.flip()
    clock.tick(60)

pygame.quit()
sys.exit()
