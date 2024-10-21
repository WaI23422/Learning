#Used Package
using Plots

#1. Start a new script file in Julia or a new notebook (either in Pluto or in Jupyter), save it as throwBall.jl.
#2. At the top of the file, define some constants with your own variable names:
#   (a) Initial height of ball at release = 1.5 m;
    h=1.5
#   (b) Gravitational acceleration = 9.8 m/s2;
    g=9.8
#   (c) Velocity of ball at release = 4 m/s;
    v=4
#   (d) Angle of the velocity vector at time of release = 45 degrees.
    θ=45 
#3. Next, make a time vector that has 1000 linearly spaced values between 0 and 1, inclusive.
t=(0:0.001:1)
#4. If x is distance, y is height, the equations below describe their dependence on time and all the other parameters 
#   (initial height h, gravitational ac-celeration g, initial ball velocity v, angle of velocity vector in degrees θ).
xt=(v*cos((θ*π)/180)).*t
yt=(h.+v*sin(θ*π/180).*t)-((g.*t.^2)./2)
#5. Approximate when the ball hits the ground.
#   (a) Find the index when the height first becomes negative.
    ind = yt[yt.<0]
    y0=yt[length(t)-length(ind)+1] 
#   (b) The distance x at which the ball hits the ground is value of x at that index.
    x0=xt[length(t)-length(ind)+1]
#   (c) Display the words: “The ball hits the ground at the distance of X meters., where X is the distance found previously.
    println("The ball hits the ground at the distance of ",x0," meters")
#6. Plot the ball trajectory:
#   (a) Plot the ball’s height on the y axis and the distance on the x axis;
#   (b) Label the axes meaningfully and give the figure a title.
#   (c) Plot the ground as a dashed black line. This should be a horizontal line going from 0 to the maximum value of x. The height of this line should be 0.
    P1=plot(
        xt,
        yt,
        xlabel="Distance (m)",
        ylabel="Ball Height (m)",
        title="Ball Trajectory v=4",
        legend=false
        )
    plot!(
        [0,maximum(xt)],
        [0,0],
        legend=false,
        line=:dash,
        color="black"
    )
#7. Run the script in the command window or on Pluto and verify that the ball hits the ground at the estimated distance.
#8. Change the initial velocity of the ball to a different value, compare and plot two trajectories.
#   Change the initial velocity of the ball to a different value:
    v1=0.5
    xt1=(v1*cos((θ*π)/180)).*t
    yt1=(h.+v1*sin(θ*π/180).*t)-((g.*t.^2)./2)
    P2=plot(
        xt1,
        yt1,
        xlabel="Distance (m)",
        ylabel="Ball Height (m)",
        title="Ball Trajectory v=0.5",
        legend=false
        )
    plot!(
        [0,2.5],
        [0,0],
        legend=false,
        line=:dash,
        color="black",
        xlim=(minimum(xt),maximum(xt)),
        ylim=(minimum(yt),maximum(yt))
    )
# compare and plot two trajectories:
    plot!(P1,P2)
