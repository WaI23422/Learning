import pygame
import sys

pygame.init()

# Constants
WIDTH, HEIGHT = 800, 600
FPS = 60
BLACK = (0, 0, 0)

# Initialize window
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Loading Screen with Bézier Curve')
clock = pygame.time.Clock()

# Bézier curve control points for the loading scene animation
control_points = [(100, 300), (300, 100), (500, 300), (700, 300)]
num_points_to_plot = 1000

# Ball properties
ball_radius = 20 # Loading Scene using object ball with radius 20.
direction = 1  # Direction of movement along the curve

def binomial_coefficient(n, k):
    """
    Calculate Binomial Coefficient for n choose k.
    """
    result = 1
    for i in range(1, k + 1):
        result *= (n - i + 1) / i
    return result

# Bezier Curve setup
def bezier_curve_point(t):
    """
    Calculate the point in bezier curve with initial t.
    """
    n = len(control_points) - 1
    x, y = 0, 0
    for j in range(n + 1):
        coefficient = binomial_coefficient(n, j)
        term = coefficient * (1 - t) ** (n - j) * t ** j
        x += term * control_points[j][0]
        y += term * control_points[j][1]
    return int(x), int(y)

# Color changing while loading
def interpolate_color(color_start, color_end, t):
    """
    Changing color according to initial t.
    """
    r = int((1 - t) * color_start[0] + t * color_end[0])
    g = int((1 - t) * color_start[1] + t * color_end[1])
    b = int((1 - t) * color_start[2] + t * color_end[2])
    return r, g, b

# Main loading screne loop
running = True
t = 0.0  # Parameter for Bézier curve
color_start = (100, 100, 255)
color_end = (255, 100, 100)

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    screen.fill(BLACK)

    # Draw Bézier curve for loading ball animation
    ball_position = bezier_curve_point(t)
    ball_color = interpolate_color(color_start, color_end, t)
    pygame.draw.circle(screen, ball_color, ball_position, ball_radius)

    # Update the parameter for the Bézier curve animation
    t += 0.005 * direction

    # Change direction when reaching the end of the curve
    if t >= 1.0 or t <= 0.0:
        direction *= -1

    # Update display
    pygame.display.flip()

    clock.tick(FPS)

pygame.quit()
sys.exit()
