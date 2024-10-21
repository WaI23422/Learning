#Import Package:
    # Go in pkg mode: 
        # Use: ] -> add Package.names
    # Go out in pkg mode:
        # Use: press Ctrl + C
    #Or
        import Pkg
        Pkg.add("QuadGK") #Integral Package 
        using QuadGK
        a=quadgk(x->exp(-2x), 0, 1, rtol=1e-3)
    # Update Package:
        Pkg.update("Package name")
# Clear Console:
    # Ctrl + L 

# Use Pluto.jl:
    import Pluto 
    Pluto.run()
# Import Pluto to VSCode:
    # Go in pkg mod -> pkg> add Pluto
using Plots
x=-2*π:0.01:2*π
y=sin.(x)
z=cos.(x)
plot(x,y,xlabel)
plot!(x,z)
collect(k)
g=p.^k
G=1/(1-p)
y=cumsum(g) 
plot(k, y, xlabel="Index", ylabel="Sum", label="finite sum", title ="g-series with p=0.99" )
plot!([0,1000],[G,G],color="Red", label="infinite sum")

function Fo(a,b)
    a!=0 && (x = -b/a)
    a==0 && println( b == 0 ? "Infinite Solution" : "No Solution")
end

function fact(n::Int)
    n >= 0 || error("n must be non-negative")
    n == 0 && return 1
    n * fact(n-1)
end
fact(1)

n=0
n==0 && print("Hello")

i = 1
S=0
for i in 1:100
    S=S+i
    i=i+1
end
print(S)

while (i<=100)
    S=S+i
    i=i+1
end
print(S)

# Modulus a divide b
    mod(a,b) #Or a%b

# Divide integer:
    div(3,1)

# Plot:
    # Design Plot:
        framestyle=:origin, 
        label="y",
        gridalpha=0.5,
        gridstyle=:dash,
        minorgrid=true
    # Plot dot:
        plot!(
        [minimum(t),],
        [0,],
        marker=true 
        )
    # Plot line:
        # Vertical:
            plot!(
            [a,a],
            [b,c],
            legend=false,
            color="black"
            )
        # Horizontal:
            plot!(
            [a,b],
            [c,c],
            legend=false,
            color="black"
            )
    # 3D - plot:
        x=range(1,stop=100,length=100)
        y=range(1,stop=100,length=100)
        f(x,y) = x+y
        my_cg = cgrad([:red,:blue])
        plot(x,y,f,st=:surface,c=my_cg,camera=(-30,30))
    # Save Plot:
        savefig(Fig,"Name.png") #Or jpg

#Print:
        print(t)
        println("$t")
    #Color print:
        for color in [:red, :cyan, :blue, :magenta]
            printstyled("Hello World $(color)\n"; color = color)
        end
    # Print text form a file:
        read("filename.txt")
    # Down the line:
        println("string")
        print("String \n")

#Multiplication
    function M(a,b)
        T=0
        for i in 1:b
            T=T+a
        end
        print(T)
    end
    M(9,72)

#Fast-Multiplication
    function FM(a,b)
        P=0
        while a > 0
            if a % 2 == 1 #or mod(a,2)==1
                P=P+b
            end
            a = a ÷ 2 #or div(a,2)
            b = b * 2
        end
        print(P)
    end
    FM(9,72)

#Sum of Odd numbers:
    x=rand(1:100,50)
    begin
        S=0
        for i = 1:length(x)
            if (mod(x[i],2) == 1)
                S = S + x[i]
            end
        end
        print(S)
    end

#Sum of Even numbers:
    x=rand(1:100,50)
    begin
        S=0
        for i = 1:length(x)
            if (mod(x[i],2) == 0)
                S = S + x[i]
            end
        end
        print(S)
    end

# && Work as a quick if-<condition> && <statement> and also work as <condition> && <condition>

#Multiplication
    function multiplication(a,b)
        p=0
        while a > 0
            if a % 2 == 1 
                p= p + b
            end
            a = a ÷ 2
            b = b * 2
        end
        return p
    end
    multiplication(24,28)

#Variable:
    for T in [Int8,Int16,Int32,Int64,Int128,UInt8,UInt16,UInt32,UInt64,UInt128]
        println("$(lpad(T,7)): [$(typemin(T)),$(typemax(T))]")
    end

#filter odd number:
    t=1:10
    filter(isodd,t)
    
#map:
    map((x) -> x * 2, [1, 2, 3])

#Type:
    typeof(x)
    #Compare Type:
        # different
            typeof(x) === typeof(y)
        # equal
            x isa Float64
        # abstract type:
            Integer <: Number
        # union type:
            IntOrFloat = Union{typeof([1 2; 1 2]),typeof([1.0 2; 1 2])}
            [1.0 2; 1 2] :: IntOrFloat
            
#Taking Integer:
    trunc(Int,Number)
    floor(1.200)
    convert(Int64,round(1.6,digits=0))

#Range:
    collect(range(4,50,step=0.1))

#Vector
    push!
    union!
    # Sort vector
        sort(V)
    # Bit Vector:
        t = BitVector((1,0,0,0,0,0,0,0,0))
        t = a[Bool[a[i] > 4 for i = 1:length(a)]]
        # Use bit vector for:
        V[t] #Erase all Elements exept first element
        # Same result with filter(x -> x > 4, V)

#convert
    t=round(exp(13),digits=8)
    t=Float64(t)

#Delete number duplicate:
    v=[1,4,3,4]
    unique(v)
    setdiff(v)

#Random numbers:
    rand(1:10,10)   
#Random Matrix:
    rand(Row,Column)

#Random a same number:
    using Random
    g = Random.seed!(12102021)

#Erase a element:
    deleteat!(t,t[4])
    t=[1,2,3,4,4]
    popat!(a,1)

#Erase all number a:
    filter!(e->e!=4,[1,2,3,4,4])
    setdiff([1,2,3,3,4],[3])
# Take all number a:
    symdiff([1,2,3,3,4],[3])

# Convert string to number:
    parse(Type,string)

#map
    map(x->x^2,[1,2])

#Complex Number:
    z = 1 + 2im
    z.im # Take Imaginary part
    z.re # Take Real part
    complex(z) # Turn Real number to Complex
    imag(z::Complex) = z.im
    real(x::Real) = x
    conj(1+im)

# String: "type"
    # Abstract Character: 'letter'
    # Replace:
        replace(string, substring => substring)
    # reverse:
        reverse(string)
    # ocurse:
        occursin("text",string)
    # split:
        # one time:
            split(text, letter)
        # multiple times:
            rsplit(text, letter)
    # strip:
        strip(string,[]) #['letter']
    # sizeof() == length(): (I think so)
    # Merge string:
        "string" * "string"
    # String multiply:
        "string"^times
        #Or:
        repeat("string",times)
    # convert to string:
        string(value, base, pad)
    # Take a Substring:
        Substring("string",start_position_letter, end_position_letter) #or Substring("string",start_position_letter:end_position_letter)
    # Find and fix:
        findfirst("letter",string,)
        findnext("letter",string,start)
        findlast("letter",string)
    # Check string start - end with:
        startswith(string,"text")
        endswith(string,"text")
    # Check if string contain:
        contains(string, string)
        contains("abbaa",r"a..a") 
    # Type:
        uppercase(string)
        uppercasefirst
        lowercase(string)
        lowercasefirst

#Build Function:
    mytypeof(x::T) where {T} = T
        mytypeof(2)

    same_type_numeric(x::T, y::T) where {T<:Number} = true
    same_type_numeric(x::Number, y::Number) = false
        same_type_numeric(1,1)

#Rational:
    2//3
    #Take numerator:
    numerator(2//3)
    #Take denominator:
    denominator(2//3)

#Matrix:
    a[Row,Column]
    B[:] # Turn all column of Matrix to a Row.
    B[:,2] # Take all row at column 2   
    vcat(a,b,c) # Merge a, b, c as Row
    hcat(a,b,c) # Merge a, b, c as Column
    sum(A, dims = 1) #Matrix sum column
    sum(A, dims = 2) #Matrix sum row
#Empty matrix:
    reshape([],Row,Column)
    Array{Float64}(undef, Row, Column)
#Matrix 0:
    zeros(T,Row,Column)
# Size:
    size([1 2 3 4; 1 2 3 4])

#Position Max:
    a=[1,2,4,3]
    argmax(a)

#RGB:
    using Images   
    using PlutoUI 
    using Plots
    
    #Point:
    t=rand(0.1:0.1:0.9) 
    RGB(rand(0.1:0.1:0.9) ,rand(0.1:0.1:0.9) ,rand(0.1:0.1:0.9) )
    [RGB(i,0,0) for i = float(0.1:0.1:0.9)]

    #Plot color: 
    A = rand(500,500)
    heatmap(A)

    #@bind in PlutoUI:
    @bind m Slider(1:100, show_value=true) #In PlutoUi
    @bind name Select([1,2,3])

    