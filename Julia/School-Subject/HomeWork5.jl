#1.a) Reactangle Rule or Midpoint Rule:
    # The logic of the problem:
        # Break [a,b] to N-square (Or n+1 point with the same distance) with the Height of the Square is f(midpoint of two point) - f is a function of a varible.
        # n+1 points with the same distance are: (b-a).N so the Width of N squares are: (b-a)/N
            # Midpoint between a and the next point (b-a)/N is (b-a)/2N
            # The distance between the midpoints of the sequence of two points is: (b-a)/N so the next midpoint is (b-a)/2N + (b-a)/N = 3(b-a)/N
            # So we have a sequence of midpoints: ((b-a)(2k-1))/2N   
                # Area under a curve is sum of Area of N-square.
    # Make Function:
        function rectangle_rule(funct::Function,a,b,N) 
            Area_Integral = 0
            Width_Nsquare = (b-a)/N
            for k in 1:N
                midpoint=a+((b-a)*(2k-1))/(2N) 
                Area_Integral += Width_Nsquare*funct(midpoint)
            end
            return Area_Integral
        end
        #Check Function:
        rectangle_rule(x->sin(x),0,2,20000509)
            
#1.b) Trapezoidai Rule
    # The logic of the problem:
        # Break [a,b] to  N-trapezoid (n+1 point with the same distance) with the Height of the Square is mean of f(a) + f(a_1) - f is a function of a varible, a and a_1 is two consecutive points.
        # n+1 points with the same distance are: (b-a).N so the Width of N trapezoid are: (b-a)/N    
            # The height of two consecutive trapezoids are: (f(a) + f(a_1))/2 + (f(a_1)+f(a_2))/2 = (f(a)+f(a_2))/2 +f(a_1)
            # So we have sum of N-trapezoid height is: (f(a)/2 + f(b)/2 + sum of f(1) to f(n-1))   (Because N-trapezoid have same Width)
            # The distance between two points is: (b-a).N 
            # So we have a sequence of two consecutive point: a + k(b-a)/N (for k in 0:N)
                # Area under a curve is sum of Area of N-trapezoid.
    # Make Function:
        function trapezoidai_rule(funct::Function,a,b,N)
            Width_Ntrapezoid = (b-a)/N
            Area_Integral = Width_Ntrapezoid*((funct(a)+funct(b))/2)
            for k in 1:(N-1)
                Area_Integral += Width_Ntrapezoid*funct(a + (k*(b-a))/N)
            end
            return Area_Integral
        end
        # Check Function:
        trapezoidai_rule(x->x^2,1,2,20000509)

#2.a) Make Plot of a function with Reactangle Rule:
    # Using Package:
        using Plots
    # Plot:
        function P_rectangle(funct::Function,a,b,N,n=1000) 
            # Coordinate function:
            rectangel_split = a:((b-a)/N):b
            x = a:((b-a)/n):b
            y = []
            for i in x
                push!(y,funct(i)) 
            end           
            # Plot f(x) function:
            plot(
                x,
                y,
                title="Rectangle rule integrating",
                xlabel="x",
                ylabel="y",
                label="function f(x)",
                gridalpha=0.5,
                gridstyle=:dash,
                minorgrid=true,
                color="red"
            )
            # Plot Rectangle based on rectangle rule:
            k = 1
            for i in 1:(length(rectangel_split)-1)
                Height=funct(a+((b-a)*(2k-1))/(2N))
                plot!(
                    [rectangel_split[i],rectangel_split[i]],
                    [0,Height],
                    label=false,
                    color=:blue
                )
                plot!(
                    [rectangel_split[i],rectangel_split[i+1]],
                    [Height,Height],
                    label=false,
                    color="blue"
                )
                plot!(
                    [rectangel_split[i+1],rectangel_split[i+1]],
                    [0,Height],
                    label=false,
                    color=:blue
                    )
                k +=1 
            end
            plot!(
                [a,b],
                [0,0],
                label=false,
                color="blue"
            )
        end
        #Function Check
        P_rectangle(x->sin(x),0,5,100)

#2.b) Make Plot of a function with Trapezoidai Rule:
    # Using Package:
        using Plots
    # Plot:
        function P_trapezoid(funct::Function,a,b,N,n=1000)
            # Coordinate function:
            trapezoid_split=a:((b-a)/N):b
            x = a:((b-a)/n):b
            y = []
            for i in x
                push!(y,funct(i)) 
            end           
            # Plot function:
            plot(
                x,
                y,
                title="Trapezoidai rule integrating",
                xlabel="x",
                ylabel="y",
                label="function f(x)",
                gridalpha=0.5,
                gridstyle=:dash,
                minorgrid=true,
                color="red"
            )
            # Plot Rectangle based on rectangle rule:
            k = 0
            for i in 1:(length(trapezoid_split)-1)
                Height=funct(a+((b-a)*k)/N)
                Height_1=funct(a+((b-a)*(k+1))/N)
                plot!(
                    [trapezoid_split[i],trapezoid_split[i]],
                    [0,Height],
                    label=false,
                    color=:blue
                )
                plot!(
                    [trapezoid_split[i],trapezoid_split[i+1]],
                    [Height,Height_1],
                    label=false,
                    color="blue"
                )
                plot!(
                    [trapezoid_split[i+1],trapezoid_split[i+1]],
                    [0,Height_1],
                    label=false,
                    color=:blue
                    )
                k +=1 
            end
            plot!(
                [a,b],
                [0,0],
                label=false,
                color="blue"
            )
        end
        #Function check
        P_trapezoid(x->sin(x),-5,5,25)

# Plot Rectangle_rule and trapezoidai_rule in 1 plot:
    plot!(P_rectangle(x->sin(x),-π,π,50),P_trapezoid(x->sin(x),-π,π,50))
# Plot Rectangle_rule with different n:
    plot!(P_rectangle(x->sin(x),-π,π,20),P_rectangle(x->sin(x),-π,π,50))
# Plot Trapezoidai_Rule with different n:
    plot!(P_trapezoid(x->sin(x),-π,π,10),P_trapezoid(x->sin(x),-π,π,50))  
#3.c) Plot error curve:
    # Using Package:
        using QuadGK
        using Plots
    # Plot:
        function error_curve(funct::Function,a,b,Split)
            Value_Integral = quadgk(funct, a, b, rtol=1e-8)
            #Plot Integration values:
            plot(
                [a,b],
                [Value_Integral[1],Value_Integral[1]],
                title="Error between Integral value with Reactangle Rule and Trapezoidai Rule",
                xlabel="Split ",
                ylabel="Value",
                label="Integral",
                legend=:bottomright,
                gridalpha=0.5,
                gridstyle=:dash,
                minorgrid=true,
                color="red"
            )
            #Rectangle Rule values:
            Area_Integral = 0
            Width_Nsquare = (b-a)/Split
            Vector_Values1 = [0.0]
            for k in 1:Split
                midpoint = a + ((b-a)*(2k-1))/(2Split) 
                Area_Integral += Width_Nsquare*funct(midpoint)
                push!(Vector_Values1,Area_Integral)
            end
            #Plot Rectangle Rule:
            plot!(
                [a:(b-a)/Split:b],
                Vector_Values1,
                label="Rectangle Rule"
            )
            #Trapezoidai Rule values:
            Width_Ntrapezoid = (b-a)/Split
            Area_Integral = 0
            Vector_Values2 = [0.0]
            for k in 1:Split
                Area_Integral += Width_Ntrapezoid*((funct(a + ((k-1)*(b-a))/Split)+funct(a + (k*(b-a))/Split))/2)
                push!(Vector_Values2,Area_Integral)
            end
            #Plot Trapezoidai Rule:
            plot!(
                [a:(b-a)/Split:b],
                Vector_Values2,
                label="Trapezoidai Rule"
            ) 
        end
        error_curve(x->sin(x),0,5,100)
            