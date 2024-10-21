#Used Package
using Plots

#1. Create a new Julia script a new notebook ,save it as seriesConvergence.jl.
#2. Define the value of p and the values of k:
p=0.99
k=(0:1000)
#3. Calculate each term in the g-series (before summation):
g=p.^k
#4.Calculate the value of the infinite series:
G=1/(1-p)
#5. Plot the value of the infinite series. 
#   Plot a horizontal red line that has x value 0 and maximum value in k (use max), and the y value is constant at G.
plot(
    [0,maximum(k)],
    [G,G],
    color="red"
    )
#6. On the same plot, plot the value of the infinite series for all values of k.
#   Plot the cumulative sum versus k. The cumulative sum of a vector is a vector of the same size, where the value of each element is equal to the sum of all elements to the left of its in the original vector (use cumsum).
#   Use blue color when plotting.
plot!(
    k,
    cumsum(g),
    color="blue"
    )
#7 Label the x and y axes and give the figure a title. 
#   Also create a legend and label the first line “infinite sum”, and the second line “finite sum”.
plot(
    [0,maximum(k)],
    [G,G],
    color="red",
    legend = true,
    label="infinite sum",
    xlabel="Index", 
    ylabel="Sum"
    )
plot!(
    k,
    cumsum(g),
    color="blue",
    legend = true,
    label="finite sum",
    title ="g-series with p=0.99",
    )
#8 Run the script and note that the finite sum of 1000 elements comes very closely to the value of the infinite sum.    
#   NOTE: the finite sum of 1000 elements comes very closely to the value of the infinite sum.

#From 1-8:
p=0.99
k=(0:1000)
g=p.^k
G=1/(1-p)
plot(
    [0,maximum(k)],
    [G,G],
    color="red",
    legend = true,
    label="infinite sum",
    xlabel="Index", 
    ylabel="Sum"
    )
plot!(
    k,
    cumsum(g),
    color="blue",
    legend = true,
    label="finite sum",
    title ="g-series with p=0.99",
    )
#   NOTE: the finite sum of 1000 elements comes very closely to the value of the infinite sum.

#9.At the bottom of the same script, initialize new variables
    #(a) p = 2
    p=2
    #(b) n is a vector containing all the integers from 1 to 500, inclusive.
    n=(1:500)
#10. Calculate each term in the p-series (before summation)
b=(n.^p).\1
#11. Calculate the value of the infinite series.
P=π^2/6
#12. Plot a figure to see the convergence of the p-series as in the g-series.
    # Plot of p-series
    plot(
        [0,maximum(n)],
        [P,P],
        color="red",
        legend = true,
        label="infinite sum",
        xlabel="Index", 
        ylabel="Sum"
        )
    plot!(
        n,
        cumsum(b),
        color="blue",
        legend = true,
        label="finite sum",
        title ="p-series with p=2",
        )
    # Plot of p-series as in the g-series
    plot(
        [0,maximum(k)],
        [G,G],
        color="red",
        legend = true,
        label="infinite sum",
        xlabel="Index", 
        ylabel="Sum"
    )
    plot!(
        k,
        cumsum(g),
        color="blue",
        legend = true,
        label="finite sum",
        title ="p-series as in g-series",
    )
    plot!(
        [0,maximum(n)],
        [P,P],
        color="red",
        legend = true,
        label="",
        xlabel="Index", 
        ylabel="Sum"
        )
    plot!(
        n,
        cumsum(b),
        color="blue",
        legend = true,
        label="",
        )
    #Display plot p-series and g-series the same time (extra):
    pseries=plot(
        [0,maximum(n)],
        [P,P],
        color="red",
        legend = true,
        label="infinite sum",
        xlabel="Index", 
        ylabel="Sum"
        )
    plot!(
        n,
        cumsum(b),
        color="blue",
        legend = true,
        label="finite sum",
        title ="p-series with p=2",
        )
    gseries=plot(
        [0,maximum(k)],
        [G,G],
        color="red",
        legend = true,
        label="",
        xlabel="Index", 
        ylabel="Sum"
        )
    plot!(
        k,
        cumsum(g),
        color="blue",
        legend = true,
        label="",
        title ="g-series with p=0.99",
        )
    plot!(gseries,pseries)