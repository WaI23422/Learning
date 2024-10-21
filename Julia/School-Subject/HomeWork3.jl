#HOMEWORK 1:   
    #a.1) a^2+b^2=2021 find a,b with a,b are Integer.
        #Function for sum a square and b square equal to 2021.  
            # SO1:
                function SS2_2021()
                    Result=[]
                    limit=floor(√2021)
                    for a in -limit:limit #(a is Integer)
                        for b in -limit:limit #(b is Integer)
                            if a^2+b^2 == 2021
                                push!(Result,((a,b)))
                            end
                        end
                    end
                    if Result == Any[]
                        print("There are no solution for a and b are integers in equation: a²+b²=2021")
                    else
                        return Result
                    end
                end
                SS2_2021()

        #Function for sum number of a square to number of b square equal to some numbers:
            # SO1:
                function Ss2_1(number::Int,a1=1,b1=1)
                    Result=[]
                    limit=floor(√number)
                    for a in -limit:limit #(a is Integer)
                        for b in -limit:limit #(b is Integer)
                            if a1*a^2+b1*b^2 == number
                                push!(Result,((a,b)))
                            end
                        end
                    end
                    if Result == Any[]
                        print("There are no solution for a and b are integers in equation: a²+b²=",number)
                    else
                        return Result
                    end
                end
                Ss2_1(9,1,2)
        
    #a.2) a^2+b^2+c^2=2021 find a,b,c.
        #Function for sum a square and b square c square equal to 2021.  
            # SO1:
                function SS3_2021()
                    Result=[]
                    limit=floor(√2021)
                    for a in -limit:limit #(a is Integer)
                        for b in -limit:limit #(b is Integer)
                            for c in -limit:limit #(c is Integer)
                                if a^2+b^2+c^2== 2021
                                    push!(Result,((a,b,c)))
                                end 
                            end
                        end
                    end
                    if Result == Any[]
                        print("There are no solution for a and b are integers in equation: a²+b²+c²=2021")
                    else
                        return Result
                    end
                end
                SS3_2021()

        #Function for sum number of a square to some number of b square and some number of c square equal to some number.
            # SO1:
                function Ss3_1(number::Int,a1=1,b1=1,c1=1)
                    Result=[]
                    limit=floor(√number)
                    for a in -limit:limit #(a is Integer)
                        for b in -limit:limit #(b is Integer)
                            for c in -limit:limit #(c is Integer)
                                if a1*a^2+b1*b^2+c1*c^2== number
                                    push!(Result,((a,b,c)))
                                end 
                            end
                        end
                    end
                    if Result == Any[]
                        print("There are no solution for a and b are integers in equation: a²+b²+c²=",number)
                    else
                        return Result
                    end
                end
                Ss3_1(9,1,1,1)
        
    #a.3) a^2+b^2+c^2+d^2=2021 find a,b,c,d 
        #Function for sum a square and b square c square d square equal to 2021.
            # SO1:
                function SS4_2021()
                    Result=[]
                    limit=floor(√2021)
                    for a in -limit:limit #(a is Integer)
                        for b in -limit:limit #(b is Integer)
                            for c in -limit:limit #(c is Integer)
                                for d in -limit:limit #(d is Integer) 
                                    if a^2+b^2+c^2+d^2== 2021
                                        push!(Result,((a,b,c,d)))
                                    end 
                                end 
                            end
                        end
                    end
                    if Result == Any[]
                        print("There are no solution for a and b are integers in equation: a²+b²+c²+d²=2021")
                    else
                        return Result
                    end
                end
                SS4_2021()

        #Function for sum a square to some number of b square, some number of c square and some number of d square equal some number.
            # SO1:
                function Ss4_1(number::Int,a1,b1,c1,d1)
                    Result=[]
                    limit=floor(√number)
                    for a in -limit:limit #(a is Integer)
                        for b in -limit:limit #(b is Integer)
                            for c in -limit:limit #(c is Integer)
                                for d in -limit:limit #(d is Integer) 
                                    if a1*a^2+b1*b^2+c1*c^2+d1*d^2== number
                                        push!(Result,((a,b,c,d)))
                                    end 
                                end 
                            end
                        end
                    end
                    if Result == Any[]
                        print("There are no solution for a and b are integers in equation: a²+b²+c²+d²=",number)
                    else
                        return Result
                    end
                end
                Ss4_1(1,1,1,1,1)
    #b) a + b =30 and 2a + 4b = 100:
        # SO1:
            function EqsLinear(limit)
                Result=[]
                for a in limit
                    for b in limit
                        if (a + b == 30) && (2a + 4b == 100) 
                            push!(Result,((a,b)))
                        end
                    end
                end 
                if Result == Any[]                
                    print("There is no solution for a, b interger")
                end
                return Result
            end
            EqsLinear(1:30)

        # SO2:
            function EqsLinear2(limit)
                Result=[]
                for b in limit
                    a= 30-b
                    if  2a + 4b == 100
                        push!(Result,((a,b)))
                    end
                end
                if Result==Any[]
                    print("There is no solution in ", limit)
                else
                    return Result
                end
            end
            EqsLinear2(70:80)

    #c) a + b + c = 100 and a*5 + b*3 + c/3 =100
        # SO1:
            function Equations(Limit)
                Result=[]
                for a in Limit
                    for b in Limit
                        for c in Limit
                            if (a+b+c==100) && (a^5+b^3+c/3==100)
                                push!(Result,((a,b,c)))
                            end 
                        end
                    end
                end
                if  Result == Any[]
                    print("There is no solution integer for a,b,c in ",Limit)
                else
                    return Result
                end
            end
            Equations(1:100)
        
        # SO2:
            function Equations2(Limit)
                Result=[]
                for a in Limit
                    for b in Limit
                        c = 100 - a - b
                        if a^5+b^3+c/3==100
                            push!(Result,((a,b,c)))
                        end 
                    end
                end
                if  Result == Any[]
                    print("There is no solution integer for a,b,c in ",Limit)
                else
                    return Result
                end
            end
            Equations2(-5000:5000)

    #d) s = 1 + (1+2)/2! + (1+2+3)/3! + ...
        # SO1:
            function Iseries(N::Int)
                N > 0 || error("Number input must be non-negative number") 
                s=0
                sum=0
                for i in 1:N
                    sum = sum + i 
                    s = s + ((sum)/factorial(big(i)))
                end
                return s
            end
            Iseries(4)
        
        # SO2:
            function mySum(N)
                s = 2
                a = 2
                for i in 2:N
                    a = a*(i+1)/(i*(i-1))
                    s = s + a
                end
                return s/2
            end
            mySum(1)

    #e) Check a number if is a Prime number.
        # SO1:
            function Prime(n::Int)
                result=[]
                for i in 1:n
                    if n/i == n ÷ i 
                        push!(result,i)
                    end
                end
                if length(result)==2
                    return true
                else
                    return false
                end
            end
            Prime(1)

        # SO2:
            function Prime2(n::Int)
                if n >= 2
                    s = 0
                    for i = 2:(n-1)
                        if n % i == 0
                            s+=1
                        end
                    end
                    if s != 0
                        return false
                    else 
                        return true
                    end
                else 
                    return false
                end
            end
            Prime2(1)

        # SO3 (the same as SO2 in function):
            function Prime3(n::Int)
                if n < 2
                    return false
                else
                    count = 0
                    for i in 2:(n-1)
                        if n%i==0
                            count=count+1
                        end
                    end
                    if count==0
                        return true
                    else
                        return false
                    end
                end
            end
            Prime3(4)
        # SO4:
            function isPrime4(n)
                n > 1 || return false
                for k in 2:√n
                    if n%k==0
                        return false
                        break
                    end
                end
                return true
            end
            isPrime4(2)

    #f) Find all Prime number in a given range:
        # SO1:
            function APrime(Limit)
                V=[]
                for i in Limit
                    if Prime(i)==true
                        push!(V,i)
                    end
                end
                return V
            end
            APrime(1:90)

        # SO2:
            function APrime1(Vector)
                V=[]
                for i in Vector
                    if Prime(i)==true
                        union!(V,i)
                    end
                end
                return V
            end
            APrime1(1:90)


    #g) Find Greatest Common Division:
        # SO1:
            function GCD(Number1::Int,Number2::Int)
                Number=max(Number1,Number2)
                Result=[]
                for i in 1:Number
                    if (mod(Number1,i) == 0) && (Number2 % i == 0)
                        push!(Result,i)
                    end
                end
                return maximum(Result)
            end
            GCD(30,15)

        # SO2 (Function in Julia):
            gcd(30,15)            
        # SO3:
            function GCD3(a, b)
                while a != b
                    if a > b
                        a = a - b
                    else
                        b = b - a
                    end
                end
                return a
            end
            GCD3(10,12)

    #h) Find Perfect Number: d(n)=2n Vd: n= 6 = 1 + 2 + 3 (1,2,3 are the divisor of 6)
        # SO1:
            function isPerfect(Number::Int)
                Number != 1 || return false 
                Divisor=[]
                for i in 1:(Number-1)
                    if mod(Number,i)==0
                        push!(Divisor,i)
                    end
                end
                if sum(Divisor) == Number
                    return true
                else
                    return false
                end
            end
            isPerfect(6)

        # SO2:
            function isPerfect3(n)
                sumDiv = 0
                for i = 1:(n-1) 
                    if n % i == 0
                        sumDiv += i
                    end
                end
                if sumDiv == n
                    return true
                else
                    return false
                end
            end
            isPerfect3(1)
        
#HOMEWORK 2:
    # 1. Approximate the exponential function using the Maclaurin series.
    #  a) Write a function which approximate this series up to a pre-defined natural numbers N, as follows:
        #SO1:
            function myExp(x, N::Int)
                N > 0 || error("N must be a natural numbers")
                s=0
                for i in 0:N
                    s = s + x^i/factorial(big(i)) 
                end
                return Float64(s)
            end
            myExp(1,30)

        #SO2:
            function myExp2(x, N)
                a = 1
                s = 1
                for i in 1:N 
                    a = a * (x/i)
                    s = s + a
                end
                return s
            end
            myExp2(1,100)

    #  b) Suppose that we use the built-in exp(x) function of Julia to compute the "exact" value of exponential function, and we want that our own myFunc can approximate exp(1.0) accurately up to 10^-8. What is the smallest N.
        #SO1:
            function myFunc(x,digits=8)
                N=1
                while true
                    if round(myExp(x,N),digits=digits)==round(exp(x),digits=digits)
                        print("The smallest of N: ", N)
                        break
                    end
                    N += 1
                end 
            end
            myFunc(1,8)

        #SO2:
            function myFunc2(x,ϵ=10^(-8))
                N=1
                error=abs(exp(x)-myExp2(x,N))
                while error > ϵ
                    N += 1
                    error=abs(exp(x)-myExp2(x,N))
                end 
                return N
            end 
            myFunc2(1,10^(-8))
        
        #SO3:
            function myFunc3(x,ϵ = 10^(-8))
                N = 0
                s = 1
                a=1
                correct = exp(1)
                error = abs(correct - s)
                while (error > ϵ)
                    N = N+1
                    a = a * (x/N)
                    s = s + a 
                    error = abs(correct-s)
                end
                return N
            end
            myFunc3(1,10^(-8))
        
    # 2. Consider the following series:
    #  a) What is the exact value of this series? You don't need a computer to answer this question. use your mathematical skill, with paper and pencil. 
        # https://www.emathhelp.net/calculators/calculus-2/series-calculator/?f=%28n%28n%2B1%29%29%2F%282%28n%21%29%29&var=&a=1&b=inf 
            print("Exact Value: ", 3exp(1)/2)
    #  b) Write a function which approximate this infinite series up to a pre-defined natural number N
        #SO1 (same as d in HOMEWORK 1):
            function mySum(N::Int)
                N > 0 || error("Number input must be non-negative number") 
                s=0
                sum=0
                for i in 1:N
                    sum = sum + i 
                    s = s + ((sum)/factorial(big(i)))
                end
                return s
            end
            mySum(100000)

        #SO2:   
            function mySum2(N::Int)
                N > 0 || error("Number input must be non-negative number") 
                s = 0
                for i in 1:N
                    n = (i*(i+1))/(2*factorial(i))
                    s = s + n
                end
                return s
            end
            mySum2(4)
        #SO3:
            function mySum3(N)
                nSum = 0
                a_n = 1
                for n = 1 : 1 : floor(Int,N)
                    nSum += a_n
                    a_n *= (n+2)/((n+1)*(n))
                end
                return nSum
            end
            mySum3(4)
        #SO4:
            function mySum4(N)
                sum = 0
                a = 0
                b = 1
                for k = 1:N
                    a = a + k  				
                    b = b * k
                    sum = sum + a/b
                end
                return sum
            end
            mySum4(4)
        #SO5:
            function mySum5(n)
                s = 2
                a = 2
                for j = 2:n
                    a = a*(j+1)/(j*(j-1))
                    s = s + a
                end
                return s/2
            end
            mySum5(10000)
    # 3. Find the Greatest Common Divisor (gcd) of two natural number.
        # Same as g in HOMEWORK 1
        # Generate randomly a vector of 100 natural numbers which are less than 1000 (use the built-in rand function of Julia) and finds the gcds of all different pairs of these numbers.
            #SO1:
                function RGCD(Vector)
                    Result=[]
                    for i in 1:(length(Vector)-1)
                        for j in (i+1):length(Vector) 
                            push!(Result,GCD(Vector[i],Vector[j]))
                        end
                    end
                    return sort(unique(Result))
                end
                RGCD(t)
            #SO2:
                function RGCD2(Vector)
                    Result=[]
                    for i in 1:(length(Vector)-1)
                        for j in (i+1):length(Vector) 
                            push!(Result,GCD3(Vector[i],Vector[j]))
                        end
                    end
                    return sort(unique(Result))
                end
                RGCD2(t)

    # 4. Test a Perfect Number:
        # Same as h in HOMEWORK 1
        # Use filter to take Perfect Number less than one billion:
            #SO1:
                filter(isPerfect3,1:10000)
                
    # 5. Find Friendly Numbers:
        #SO1:
            function isFriendly(a,b)
                a!=1 || return false
                b!=1 || return false
                PDivisora=[]
                PDivisorb=[]
                for i in 1:(a-1)
                    if mod(a,i) == 0 
                        push!(PDivisora,i)
                    end
                end
                for j in 1:(b-1)
                    if mod(b,j) == 0 
                        push!(PDivisorb,j)
                    end
                end
                if (sum(PDivisora)==b) && (sum(PDivisorb)==a)
                    return true
                else 
                    return false
                end
            end
            isFriendly(220,284)
        
        #SO2:
            function divSumN(Number) # sum of proper divisors
                divSum = 0
                if Number < 2
                    return 0
                else
                    for i = 2:1:floor(Int,sqrt(Number))
                        if Number % i == 0
                            if i == (Number/i)
                                divSum += i
                            else
                                divSum += (i+Number/i)
                            end
                        end
                    end
                end 
                return floor(Int,divSum + 1)
            end
            
            function isFriendly2(a, b)
                if divSumN(a) == b && divSumN(b) == a
                    return true
                else
                    return false
                end
            end
            isFriendly2(220,284)
            
    # 6. Test the Prime:
        # Same as e in HOMEWORK 1
        # List all prime numbers less than one billion:
            #SO1:
                function isPrime(Limit::Int)
                    PrimeNumbers=[]
                    for i in 1:(Limit-1) 
                        if Prime(i) == true
                            push!(PrimeNumbers,i)
                        end
                    end
                    return PrimeNumbers
                end
                isPrime(1000)
            
            #SO2:
                filter(isPrime4, 1:1000000)
                filter(Prime,1:1000000)

#HOMEWORK 3:
    # 7. Given a vector v of numbers, write a function which finds the maximal number without using the maximum function of Julia.
        #SO1:
            function findMax(Vector)
                Vector=sort(Vector)
                return Vector[length(Vector)]
            end
            findMax(rand(100))
        
        #SO2:
            function findMax2(Vector)
                i = 1
                Vector=unique(Vector)
                while true
                    if Vector[i]<Vector[i+1]
                        Vector=Vector[Vector.>=Vector[i+1]]
                    elseif Vector[i]==Vector[i+1]
                        i += 1
                    else
                        Vector=Vector[Vector.>=Vector[i]]
                    end
                    # Break Condition:
                    Condition = Vector .== Vector[i]
                    if (length(Vector) == 1) || (!any(x -> x == false, Condition))
                        return Vector[1] 
                        break
                    end
                end
            end
            findMax2(t) 
            
        #SO3:   
            function findMax3(Vector)
                i=1
                while true
                    if Vector[i] < Vector[i+1]
                        i += 1
                    elseif (i == length(Vector)-1) && (Vector[i]<Vector[i+1])
                        return Vector[length(Vector)]
                        break
                    elseif (i == length(Vector)-1) && (Vector[i]>=Vector[i+1])
                        return Vector[length(Vector)-1]
                        break
                    else
                        Vector[i+1]=Vector[i]
                        i += 1        
                    end
                end
            end
            findMax3(rand(100))
            
        #SO4:
            function findMax4(a)
                max = a[1]
                for i = 1:length(a)
                    if a[i] > max
                        max = a[i]
                    end
                end
                return max
            end
            findMax4(rand(100000))

        #SO5: 
            function findmax5(Range)
                coor_1 = 1
                coor_2 = 2
                while (coor_1 <= length(Range)) && (coor_2 <= length(Range))
                    if Range[coor_1] > Range[coor_2]
                        coor_2 += 1
                    else
                        coor_1 += 1 
                    end    
                end
                if coor_1 > length(Range)
                    return Range[coor_2]
                else 
                    return Range[coor_1]
                end 
            end
            findmax5(rand(1:100,200))
    
    # 7.1. Find minimum number:
        # SO1:
            function findMin(a)
                min = a[1]
                for i in 1:length(a)
                    if a[i] < min
                        min = a[i]
                    end
                end
                return min
            end
            findMin(rand(100000))

    # 8. Find the minimum number of natural numbers whose sum of squares is 2021.
        #SO1:
            function getminsquare(n)
                n <= 3 && return n 
                res = n
                for x in (1:n+1)
                    temp = x^2
                    if temp > n
                        break
                    else
                        res = min(res, 1 + getminsquare((n - temp)))
                    end
                end
                return res
            end
            getminsquare(2021)
            
    # 9. Find the number of digits of a given natural number n. For example, n = 123321 has 6 digits.
        #SO1:
            function numberDigits(n)
                (n > 0) && (n == floor(n)) || error("Number must be a natural number")
                Digits=1
                t = div(n,10)
                while t != 0
                    t=div(t,10)
                    Digits = Digits + 1 
                end
                return Digits
            end
            numberDigits(12345)
        
        #SO2:
            function numberDigits2(n)
                (n > 0) && (n == floor(n)) || error("Number must be a natural number")
                return trunc(Int64,log10(n))+1
            end
            numberDigits2(30000)

        #SO3:
            function numberDigits3(n)
                (n > 0) && (n == floor(n)) || error("Number must be a natural number")
                return length(string(n))
            end
            numberDigits3(30000)
            
        #SO4:
            function numberDigits4(n)
                (n > 0) && (n == floor(n)) || error("Number must be a natural number")
                return length(digits(n))    
            end
            numberDigits4(30000)
            
    # 10. A natural number is divisible by 3 if the sum of their digits is divisible by 3. Use this divisibility rule to check whether a number is divisible by 3 or not.
        #SO1:
            function isDivisibleBy3_1(n)
                (n > 0) && (n == floor(n)) || error("Number must be a natural number")
                if mod(n,3)==0 #Or (n/3)==div(n,3)
                    return true
                else
                    return false
                end
            end
            isDivisibleBy3_1(123)
        
        #SO2:
            # Number: AB/3 = (A*10 + B)/3 = C + a/3 + c + b/3 = d + (a+b)/3 ( A remainder a and B remainder b after divise by 3 ,).  
            function isDivisibleBy3_2(n)
                (n > 0) && (n == floor(n)) || error("Number must be a natural number")
                digit = []  
                while n != 0
                    rem = n % 10  
                    push!(digit, rem)
                    n = div(n,10)  
                end
                if sum(digit)/3 == floor(sum(digit)/3)
                    return true
                else
                    return false
                end
            end
            isDivisibleBy3_2(32154891)
        
        #SO3:
            function isDivisibleBy3_3(n)
                s= 0 
                while n > 0
                    s = s + mod(n,10)
                    n = div(n,10)
                end
                if s/3 == div(s,3)
                    return true
                else 
                    return false
                end
            end
            isDivisibleBy3_3(155)

    # 11. What is the divisibility rule by 11? Similar to the previous question, write a function to implement the check:
        # SO1:
            function isDivisibleBy11_1(n::Int)
                n > 0 || error("Number must be a natural number")
                if mod(n,11)==0 #Or (n/11)==div(n,11)
                    return true
                else
                    return false
                end
            end
            isDivisibleBy11_1(165)
        
        # SO2:
            function isDivisibleBy11_2(n)
                (n > 0) && (n == floor(n)) || error("Number must be a natural number")
                Sum = 0
                digit = []
                # Split number:  
                t=n
                while t != 0
                    rem = t % 10  
                    push!(digit, rem)
                    t = div(t,10)  
                end
                reverse(digit)
                # Sum digits:
                for i in 1:numberDigits(n)
                    if iseven(i)
                        Sum = Sum - digit[i]
                    else
                        Sum = Sum + digit[i]
                    end
                end
                if Sum/11 == trunc(Int64,Sum/11)
                    return true
                else
                    return false
                end
            end
            isDivisibleBy11_2(11)
    
    # 12. Write a function which factors a given natural number n into prime num-bers. For example, the factorization of 20 is [2, 2, 5]; that of 5100 is [2, 2, 3, 5, 5, 17].
        # SO1:
            function factorize1(n)
                Result=[]
                for i in APrime(1:n)
                    while mod(n,i) == 0 
                        n = n/i
                        push!(Result,i)
                    end
                end
                return [Result]
            end
            factorize1(5100)
        
        # SO2:
            function factorPrime(n)
                number = n
                factorizeList = []
                # filter 2
                while mod(n,2) == 0
                    n >>= 1
                    push!(factorizeList, 2)
                end
                # filter odd prime
                for i = 3:2:floor(Int, sqrt(n))
                    while mod(n,i) == 0
                        push!(factorizeList, i)
                        n ÷= i
                    end
                end
                # if n > 2 && isPrime(n)==true--> push!(factorizeList,n)
                if n>2
                    push!(factorizeList, n)
                end
                return factorizeList
            end
        # SO3:
            function factorize(N)
                result = []
                for k = 2:N
                    if N%k == 0
                        while (N/k == floor(N/k))
                            N = N/k
                            push!(result,k)
                        end
                    end
                end
                return result
            end
            factorize(363)
    
    # 13. Compute Babylon  
        # a.Function compute the square root of a given number S using the method above with N iterative steps.
            # SO1:
                function Babylonian(S, N, guess)
                    S > 0 || error("S must be a non-negative real number")
                    S != 0 || return x = 0
                    x = guess
                    for i in 1:N
                        x = (x + S/x)/2     
                    end
                    return x
                end
                Babylonian(16,900,5)

            # SO2:
                function BabylonianGuess(S)      
                    str = string(floor(S),base=10)     
                    L = length(strip(str))      
                    d = ceil(L/2)                  
                    guess2 = 2*10^(d-1)
                    guess7 = 7*10^(d-1)
                    if abs(guess2^2 - S) < abs(guess7^2 - S) 
                        return guess2 
                    else 
                        return guess7
                    end   
                end
                BabylonianGuess(900)
                
                function BabylonianSqrt(S,epsilon=10^-8);
                    if S < 0 
                        error("Number must be non-negative real number")
                    elseif S == 0
                        x = 0                  
                    else
                        x = BabylonianGuess(S)
                        xPrev = 0
                        while (abs(x - xPrev) > epsilon)
                          xPrev = x
                          x = (xPrev + S/xPrev)/2
                        end
                    end
                    return x 
                end
                BabylonianSqrt(1,10^-8)
                
        # b. Plot a figure showing approximate error with respect to N.
            # Using Package:
                using Plots    
            # SO1:
                function ComputeBabylon(guess,S,timeN)
                    S > 0 || error("S must be a non-negative real-number")
                    Result=[]
                    x = guess
                    for i in timeN
                        x = (x + S/x)/2
                        push!(Result,x)     
                    end
                    return Result
                end
                function PlotBabylonian(guess,S,N)
                    timeN = 1:N
                    y = ComputeBabylon(guess,S,timeN)
                    plot(
                        timeN,
                        y,
                        title=("Babylonian compute to the square-root of Julia at N"),
                        xlabel=("x"),
                        ylabel=("y"),
                        framestyle=true,
                        label="Babylonian",
                        gridalpha=0.5,
                        gridstyle=:dash,
                        minorgrid=true
                        )
                    plot!(
                        [1,N],
                        [sqrt(S),sqrt(S)],
                        label="Square-root"
                        )
                end
                PlotBabylonian(1,2,10)
    
    # 14. Stirling Formula
        # a. Write a function to approximate factorials of n for all n = 10, 11, . . . , 100
            # SO1:
                function StirlingFormula(n,space=0.1)
                    n != 1 || return 1
                    Result=[]
                    for θ in (0:space:1) 
                        n0 = sqrt(2π*n)*((n/exp(1))^n)*exp(θ/(12*n))
                        push!(Result,n0)
                    end
                    return Result
                end
                StirlingFormula(3)
                
            # b. Plot:
                # SO1:
                    function PlotStirlingFormula(n)
                        x = 0:0.1:1
                        y = StirlingFormula(n)
                        plot(
                            x,
                            y,
                            title=("Stirling Formula compute to the factorial of Julia"),
                            xlabel=("x"),
                            ylabel=("y"),
                            framestyle=true,
                            label="Stirling Formula",
                            gridalpha=0.5,
                            gridstyle=:dash,
                            minorgrid=true
                            )
                        plot!(
                            [0,1],
                            [factorial(big(n)),factorial(big(n))],
                            label="Factorial"
                            )        
                    end
                    PlotStirlingFormula(10)
    
    # 15. To find the binary representation (base 2) of a natural number n in base 10, we repeatedly divide it by 2 and record the remainders in the reverse order. Write a function which binarizes a natural number.
        # SO1:
            function binarize1(n)
                Result=[]
                while div(n,1) > 0
                    if mod(n,2) == 1
                        n=div(n,2) 
                        push!(Result,1)
                    else
                        n=div(n,2)
                        push!(Result,0)
                    end 
                end
                return reverse(Result)
            end
            binarize1(55)
            
        # SO2:
            function binarize(n)
                List = []
                begin
                    while n> 0
                        find = n%2
                        push!(List, find)
                        n = n÷2
                    end
                end
                return reverse(List)
            end
            binarize(13)
            
           