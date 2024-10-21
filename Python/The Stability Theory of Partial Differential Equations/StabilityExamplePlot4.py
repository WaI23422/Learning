import numpy as np
import matplotlib.pyplot as plt

def add_arrow(line, position=None, direction='right', size=50, color=None):
    if color is None:
        color = line.get_color()

    xdata = line.get_xdata()
    ydata = line.get_ydata()

    if position is None:
        position = xdata.mean()

    start_ind = np.argmin(np.absolute(xdata - position))
    if direction == 'right':
        end_ind = start_ind + 1
    else:
        end_ind = start_ind - 1

    line.axes.annotate('',
        xytext=(xdata[start_ind], ydata[start_ind]),
        xy=(xdata[end_ind], ydata[end_ind]),
        arrowprops=dict(arrowstyle="->", color=color),
        size=size
    )

# Set up polar coordinates
r = 0.5
theta = np.linspace(0, 2*np.pi, 1000)

# Define the function for theta' = f(r)
theta_prime = np.sin(r)

# Plot the polar curve without angle numbers
fig, ax = plt.subplots(subplot_kw={'projection': 'polar'})
line1, = ax.plot(theta, theta_prime*np.ones_like(theta), label=r'$\theta\' = \sin(r)$ for $r = 1$')

r = 2
theta_prime = np.sin(r)
line2, = ax.plot(theta, theta_prime*np.ones_like(theta), label=r'$\theta\' = \sin(r)$ for $r = 2$')

# Add radius lines
for angle in np.arange(0, 2*np.pi, np.pi/4):
    ax.plot([angle, angle], [0, 2], color='gray', linestyle='--')

# Remove angle numbers and grid
ax.set_xticklabels([])
ax.set_yticklabels([])
ax.set_xticks([])
ax.set_yticks([])
ax.grid(False)

# Add arrows
add_arrow(line1, position=np.pi/4, direction='right', size=20, color='blue')
add_arrow(line2, position=np.pi/4, direction='right', size=20, color='blue')

# Remove the outline circle
ax.set_frame_on(False)

new_axis = fig.add_axes(ax.get_position(), frameon=False)
new_axis.plot()

line1.set_color('blue')
line2.set_color('blue')

# Show the plot
plt.title('Polar Plot with Arrows and Radius Lines')
plt.show()
