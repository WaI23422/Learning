#Used Package:
using  Plots

#Solve First-Order Equations:
    # Solution 1:
    function FO1(a,b)
        if a != 0
            print("The equation y = ",a,"x + ",b," have solution: x = ",-b/a)
        else 
            if b == 0
                print("The equation y = ",a,"x + ",b," have 'Infinite Solution'")
            else
                print("The equation y = ",a,"x + ",b," have 'No Solution'")
            end
        end
    end
    FO1(0,2)

    # Solution 2:
    function FO2(a,b)
        a != 0 ? 
        print("The equation y = ",a,"x + ",b," have solution: x = ",-b/a) :  
            b==0 ? 
            print("The equation y = ",a,"x + ",b," have 'Infinite Solution'") : 
                print("The equation y = ",a,"x + ",b," have 'No Solution'")
    end
    FO2(1,1)

#Sovle Second-Order Equations:
    #Solution 1:
    function SO1(a,b,c)
        if a == 0
            FO1(b,c)
        else 
            if b^2-4*a*c == 0
                print("The equation y = ",a,"x² + ",b,"x + ",c," have double solution: x1 = x2 = ", -b/2a)
            elseif b^2-4*a*c > 0
                print("The equation y = ",a,"x² + ",b,"x + ",c," have two solutions: x1 = ", round((-b+sqrt(b^2-4*a*c))/2a,digits=3)," and x2 = ",round((-b-sqrt(b^2-4*a*c))/2a,digits=3))
            else
                print("The equation y = ",a,"x² + ",b,"x + ",c," have 'No solutions' on the field of real numbers")
            end
        end
    end
    SO1(-3,2,1)

    #Solution 2:
    function SO2(a,b,c)
        a == 0 ? 
        FO2(b,c) :  
            b^2-4*a*c == 0 ? 
            print("The equation y = ",a,"x² + ",b,"x + ",c," have double solution: x1 = x2 = ", -b/2a) : 
                b^2-4*a*c > 0 ?
                print("The equation y = ",a,"x² + ",b,"x + ",c," have two solutions: x1 = ", round((-b+sqrt(b^2-4*a*c))/2a,digits=3)," and x2 = ",round((-b-sqrt(b^2-4*a*c))/2a,digits=3)) : 
                    print("The equation y = ",a,"x² + ",b,"x + ",c," have 'No solutions' on the field of real numbers")
    end
    SO2(-3,2,1)

# Plot for Second-Order Equations:
function SO3(a,b,c)
    a != 0 || error("a must be non-zero for a Second-Order equation")
    begin
        x=-b/2a
        t=minimum(x)-20:0.1:maximum(x)+20
        y=a.*t.^2+b.*t.+c
        if b^2-4*a*c == 0
            begin
                print("The equation y = ",a,"x² + ",b,"x + ",c," have double solution: x1 = x2 = ", x) 
                plot(
                    minimum(x)-20:0.1:maximum(x)+20,
                    y,
                    title=string("The equation y = ",a,"x² + ",b,"x + ",c),
                    ylim=(minimum(y)-(maximum(y)/2),maximum(y)),
                    xlim=(minimum(t),maximum(t)),
                    framestyle=:origin,
                    label="y",
                    gridalpha=0.5,
                    gridstyle=:dash,
                    minorgrid=true
                    )
                plot!(
                    [x,],
                    [(a*x^2+b*x+c),],
                    marker=:red,
                    label=false
                )
                plot!(
                    [x,x],
                    [minimum(y)-(maximum(y)/2),maximum(y)],
                    label=false,
                    line=:dash,
                    color=:black
                )
            end
        elseif b^2-4*a*c > 0
            begin
                x1=round((-b+sqrt(b^2-4*a*c))/2a,digits=3)
                x2=round((-b-sqrt(b^2-4*a*c))/2a,digits=3)
                print("The equation y = ",a,"x² + ",b,"x + ",c," have two solutions: x1 = ", x1," and x2 = ",x2)
                plot(
                    minimum(x)-20:0.1:maximum(x)+20,
                    y,
                    title=string("The equation y = ",a,"x² + ",b,"x + ",c),
                    ylim=(minimum(y)-(maximum(y)/2),maximum(y)),
                    xlim=(minimum(t),maximum(t)),
                    framestyle=:origin,
                    label="y",
                    gridalpha=0.5,
                    gridstyle=:dash,
                    minorgrid=true
                )
                plot!(
                    [x1,],
                    [(a*x1^2+b*x1+c),],
                    marker=:red,
                    label=false
                )
                plot!(
                    [x2,],
                    [(a*x2^2+b*x2+c),],
                    marker=:red,
                    label=false
                )
                plot!(
                    [x,x],
                    [minimum(y)-(maximum(y)/2),maximum(y)],
                    label=false,
                    line=:dash,
                    color=:black
                )
            end
        else
            print("The equation y = ",a,"x² + ",b,"x + ",c," have 'No solutions' on the field of real numbers")
        end
    end    
end
SO3(2,-4,2)

# Bernoulli experiments a fair coin:
    #Solution 1 (h for heads, t for tails, x for the times the coin been tossed)
    begin
        function Be(x::Int,ht::Int)
            x >= ht || error("x must be large or equal to ht")
            h=0.5^ht*0.5^(x-ht)*binomial(x,ht)
            print("probability is: ", h) 
        end
        function Be(x::Int,heads::Int,tails::Int)
            x >= heads || error("x must be large or equal to heads")
            x >= tails || error("x must be large or equal to tails")
            h=0.5^heads*0.5^(x-heads)*binomial(x,heads)
            t=0.5^tails*0.5^(x-tails)*binomial(x,tails)
            print("probability of heads is: ", h,", probability of tails is: ", t) 
        end
    end
    Be(6,6,3)

#Toss a coin:
function TC()
    r=rand()
    if r > 0.5
        "Head"
    elseif r==0.5    
        "Between"
    else
        "Tail"
    end    
end
TC()

#Toss a coin n-time and calculate probability of heads, tails.
    #?1:
    function RP(times::Int)
        begin
            time=rand(times)
            heads=sum(time.>0.5)
            tails=sum(time.<0.5)
            print("probability of heads is: ", round(heads/times,digits=2),", probability of tails is: ", round(tails/times,digits=2))
        end 
    end
    RP(1000)



