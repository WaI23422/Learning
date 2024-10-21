# 16. A bank offers an interest rate of r% per term (aka period) for its saving accounts. 
# Interest rates are compounded; that is the obtained interest of period t is added to the balance to compute the interest of period
# t + 1, for t = 1, 2, . . . . Suppose that your initial balance is 1, the rate is r = 0.08/year.   
    #a.1) You lend your money to the bank for n years. 
    # What is your final balance that the bank need to pay you at due date? 
    # Draw the plot of amounts with respect to n, for n ranges from 1 to 100.
        # SO1:
            function Final_Balance_1(Years::Number,Period=1::Number,Initial_Balance = 1::Number,Interest_year=0.08)
                Final_Balance = Initial_Balance
                Interest_Period = Interest_year/Period
                Times = Period*Years
                for i in 1:Times
                    Final_Balance += Final_Balance*Interest_Period
                end
                return Final_Balance
            end 
            Final_Balance_1(10)

        # SO2:
            function Final_Balance_2(Years::Number,Period=1,Initial_Balance = 1,Interest_year=0.08)
                Final_Balance = Initial_Balance
                Final_Balance = Final_Balance*(1 + (Interest_year)/Period)^(Period*Years)
                return Final_Balance
            end
            Final_Balance_2(1)
    
    #a.2) Plot:
        # Using Package:
            using Plots
        # Plot Balance:
            # Y Coordinate:
            function Plot_FinalBalance(Years::Number,Period=1,Initial_Balance = 1,Interest_year=0.08)
                # Find Balance per Period in each Years:
                Balance_Period=[]
                push!(Balance_Period,1) # Balance at beginning
                Final_Balance = Initial_Balance
                Interest_Period = Interest_year/Period
                Times = Period*Years
                for i in 1:Times
                    Final_Balance += Final_Balance*Interest_Period
                    push!(Balance_Period,Final_Balance)
                end
                plot(
                    [0:Times],
                    Balance_Period,
                    title=string("Final Balance at ",Years," years with period of ", Period),
                    xlabel="Period",
                    ylabel="Balance",
                    label=false,
                    gridalpha=0.5,
                    gridstyle=:dash,
                    minorgrid=true,
                    color="red"
                )
            end
            Plot_FinalBalance(100)
    
    #b. Suppose that you plan to have at least s as your balance at the due date, for example s = 3. How long do you have to wait for?
        # SO1:
            function TimesAtBalance(Balance,Period=1,Initial_Balance=1)
                Years = 0
                Final_Balance=Final_Balance_1(Years,Period,Initial_Balance)
                while Final_Balance < Balance
                    Years +=1
                    Final_Balance=Final_Balance_1(Years,Period,Initial_Balance)
                end
                return Years
            end
            TimesAtBalance(1)
    
    #c. Suppose that the bank offers different packages with different terms and rates, of 4% per six months, of 2% per quarter, and of 0.67% permonth. 
    #You plan to deposit for 5 years. What package should you choose?
        # SO1:
            begin
                a = Final_Balance_1(5,2*5,1,0.04)
                b = Final_Balance_1(5,4*5,1,0.02)
                c = Final_Balance_1(5,12*5,1,0.0067)
                if max(a,b,c) == a
                    print("Choose Package a")
                elseif max(a,b,c) == b
                    print("Choose Package b")
                else
                    print("Choose Package c")
                end 
            end

# 17. Write a function which returns unique numbers of a given vector of numbers. 
    # For example uniq([1, 3, 2, 2, 3, 1]) is [1,3,2]. This is similar to the built-in unique() function of Julia.
    # SO1:
        function Unique1(Vector,i=1,j=2)
            while true  
                if length(Vector) < 3
                    if Vector[i]==Vector[j-1]
                        return [Vector[i]]
                        break
                    elseif Vector[i]==Vector[j]
                        return [Vector[i]]
                        break
                    else
                        return Vector
                        break
                    end
                else 
                    if Vector[i]==Vector[j]
                        if j == length(Vector)
                            if i != length(Vector)-1
                                Vector = Vector[1:j-1]
                                j = j-1
                            else
                                return Vector[1:j-1]
                                break
                            end 
                        else
                            Vector=deleteat!(Vector,j)
                        end
                    else
                        if i == length(Vector)-1
                            return Vector
                            break 
                        elseif  j == length(Vector)
                            i += 1
                            j = i+1  
                        else
                            j += 1
                        end
                    end
                end
            end
        end
        Unique1(rand(1:10,20))
        
    # SO2:
        function Unique2(Vector)
            Unique_Vector=[]
            for x in Vector
                if x ∉ Unique_Vector #!(x in Unique_Vector) or !∈(x,Unique_Vector)
                    push!(Unique_Vector,x) 
                end
            end
            return Unique_Vector
        end
        Unique2(rand(1:10,20))

    # SO3:
        function Unique3(Vector)
            Unique_Vector = []
            while true
                if length(Vector) != 0
                    push!(Unique_Vector , Vector[1])
                    Vector = Vector[Vector .!= Vector[1]]
                else 
                    return Unique_Vector
                    break
                end
            end
        end
        Unique3(t)

# 18. Given a matrix of shape m × n (m rows, n columns). Write some basic functions that do the following:
    # a.Suppose that the matrix is square, m = n. Write a function to compute the sum of elements on its main diagonal. Write another function to compute the sum of elements on its back-diagonal.
        # SO1:
            # Sum Main Diagonal:
            function Sum_MainDiagonal(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Main = 0
                Sum_Secondary = 0
                for i in 1:length(Square_Matrix[:,1])
                    for j in 1:length(Square_Matrix[:,1])
                        if i == j 
                            Sum_Main += Square_Matrix[i,j]
                        end
                        if (i+j == length(Square_Matrix[:,1])+1) 
                            Sum_Secondary += Square_Matrix[i,j]
                        end
                    end
                end
                print("Sum main diagonal:",Sum_Main ," Sum secondary diagonal:",Sum_Secondary)
            end
            Sum_MainDiagonal([9 2 3; 2 3 4; 9 5 6])

        # SO2:
            # Sum Main Diagonal:
            function Sum_MainDiagonal_2(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Main = 0
                Sum_Secondary = 0
                for j in 1:length(Square_Matrix[:,1])
                    Sum_Main += Square_Matrix[j,j]
                    Sum_Secondary += Square_Matrix[j,length(Square_Matrix[:,1])+1-j] #Or Square_Matrix[length(Square_Matrix[:,1])+1-j,j]
                end
                print("Sum main diagonal:",Sum_Main ," Sum secondary diagonal:",Sum_Secondary)
            end
            Sum_MainDiagonal_2([9 2 3; 2 3 4; 9 5 6])
    # b.Again, suppose that m = n. Write a function to compute the sum of elements on the upper-right of the matrix, that is all elements above the main diagonal.
        # SO1:
            function Sum_UpperDiagonal(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Upper= 0
                for Row in 1:length(Square_Matrix[:,1])
                    for Column in 1:length(Square_Matrix[:,1])
                        if Row < Column
                            Sum_Upper += Square_Matrix[Row,Column] 
                        end
                    end
                end
                return Sum_Upper
            end
            Sum_UpperDiagonal([1 2 3 4; 4 5 6 2; 7 8 9 1; 8 8 1 9])

        # SO2:
            function Sum_UpperDiagonal_2(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Upper= 0
                Sum_UpperMatrix=0
                for i in 1:length(Square_Matrix[:,1])
                    Sum_Upper += Square_Matrix[i,i]
                    Sum_UpperMatrix += sum(Square_Matrix[i,i:length(Square_Matrix[1,:])])
                end
                return (Sum_UpperMatrix - Sum_Upper) 
            end
            Sum_UpperDiagonal_2([1 2 3 4; 4 5 6 2; 7 8 9 1; 8 8 1 9])
        
        # SO3:
            function Sum_UpperDiagonal_3(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Upper= 0
                for Row in 1:length(Square_Matrix[:,1])
                    for Column in Row+1:length(Square_Matrix[:,1])
                        Sum_Upper += Square_Matrix[Row,Column] 
                    end
                end
                return Sum_Upper
            end
            Sum_UpperDiagonal_3([1 2 3 4; 4 5 6 2; 7 8 9 1; 8 8 1 9])
    
    # b.1 Lower Matrix:
        # SO1:
            function Sum_LowerDiagonal(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Lower= 0
                for Row in 1:length(Square_Matrix[:,1])
                    for Column in 1:length(Square_Matrix[:,1])
                        if Row > Column
                            Sum_Lower += Square_Matrix[Row,Column] 
                        end
                    end
                end
                return Sum_Lower
            end
            Sum_LowerDiagonal([1 2 3 4; 4 5 6 2; 7 8 9 1; 8 8 1 9])

        # SO2:
            function Sum_LowerDiagonal_2(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Main_Diagonal = 0
                Sum_LowerMatrix=0
                for i in 1:length(Square_Matrix[:,1])
                    Sum_Main_Diagonal += Square_Matrix[i,i]
                    Sum_LowerMatrix += sum(Square_Matrix[i:length(Square_Matrix[:,1]),i])
                end
                return (Sum_LowerMatrix - Sum_Main_Diagonal) 
            end
            Sum_LowerDiagonal_2([1 2 3 4; 4 5 6 2; 7 8 9 1; 8 8 1 9])
        
        # SO3:
            function Sum_LowerDiagonal_3(Square_Matrix::Matrix)
                length(Square_Matrix[:,1]) == length(Square_Matrix[1,:]) || error("Matrix must have the form m.n where m equals n")
                Sum_Lower= 0
                for Column in 1:length(Square_Matrix[:,1])
                    for Row in Column+1:length(Square_Matrix[:,1])
                        Sum_Lower += Square_Matrix[Row, Column] 
                    end
                end
                return Sum_Lower
            end
            Sum_LowerDiagonal_3([1 2 3 4; 4 5 6 2; 7 8 9 1; 8 8 1 9])
    # c.Write a function to compute the sum of elements on the same columns of the matrix. The result should be a vector of n elements.
        # SO1:
            function sum_column(matrix::Matrix)
                Sum_Vector=[]
                for i in 1:length(matrix[1,:])
                    push!(Sum_Vector,sum(matrix[:,i]))
                end
                return Sum_Vector
            end
            sum_column([1 2 3; 3 4 5])
        
        # SO2:
            function sum_column_2(matrix::Matrix)
                Sum_Vector=Array{Float64}(undef,1,size(matrix,2))
                for i in 1:size(matrix,2)
                    Sum_Vector[1,i] = sum(matrix[:,i])
                end
                return Sum_Vector
            end
            sum_column_2([1 2 3; 3 4 5])

        # SO3:
            sum([1 2 3; 3 4 5],dims=1)

    # d.Same as the question right above but change columns to rows. Now the result should be a vector of m elements.
        # SO1:
            function sum_row(matrix::Matrix)
                Sum_Vector=[]
                for i in 1:length(matrix[:,1])
                    push!(Sum_Vector,sum(matrix[i,:]))
                end
                return Sum_Vector
            end
            sum_row([1 2 3; 3 4 5])
        
        # SO2:
            function sum_row_2(matrix::Matrix)
                Sum_Vector=Array{Float64}(undef,size(matrix,1),1)
                for i in 1:size(matrix,1)
                    Sum_Vector[i,1] = sum(matrix[i,:])
                end
                return Sum_Vector
            end
            sum_row_2([1 2 3; 3 4 5])

        # SO3:
            sum([1 2 3; 3 4 5],dims=2)

# 19. Write a function to fill in a matrix representing a Pascal triangle up to a predefined n.
    # SO1:
        function Pascal(Input_Number::Integer)
            matrix = [1 zeros(Int, 1, Input_Number)]
            pascal = matrix
            for row in 2:Input_Number+1
                for column in 1:row-1
                    if column == 1
                        value = sum(pascal[row-1,column:column+1])
                        matrix = [1 value]
                    else
                        value = sum(pascal[row-1,column:column+1])
                        matrix = [matrix value] 
                    end
                end
                matrix = [matrix zeros(Int, 1, Input_Number+1-row)]
                pascal = [pascal; matrix]
            end
            return pascal
        end
        Pascal(3)

# 20. Write a function to fill in a matrix of shape m × n with natural numbers from 1 to m ∗ n in a clockwise cyclic way.  
    # SO1:
        function Spiral_Matrix(Row::Integer,Column::Integer)
            # Condition:
            (Row >0 || Column>0) || error("Number of Rows and Columns have to greater than 0")
            # Matrix generation:
            if Row == 1
                matrix = Array{Float64}(undef, 1, 0)
                for number in 1:Column 
                    matrix = [matrix number] 
                end
                return matrix
            elseif Column == 1
                matrix = Array{Float64}(UndefInitializer(), 0, 1)
                for number in 1:Row
                    matrix = [matrix; number]
                end 
                return matrix
            else
                # Create matrix zeros matrix:
                matrix = zeros(Float64, Row, Column)
                # First Row Matrix:
                for i in 1:Column
                    matrix[1,i] = i
                end  
                # Initialize data:
                number = Column + 1 
                Position_Row = collect(2:Row)
                Position_Column = collect(1:Column)
                Direction = 1
                # Matrix construction: 
                while number <= Row*Column
                    # Go Right:
                    if mod(Direction,4) == 0 
                        Position_Row = reverse(Position_Row)
                        for i in 1:length(Position_Column)
                            matrix[Position_Row[1],Position_Column[i]] = number
                            number += 1  
                        end
                        popat!(Position_Row,1)
                        Direction += 1
                    # Go Down:    
                    elseif mod(Direction,4) == 1
                        Position_Column = reverse(Position_Column)
                        for i in 1:length(Position_Row)
                            matrix[Position_Row[i],Position_Column[1]] = number
                            number += 1  
                        end
                        popat!(Position_Column,1)
                        Direction += 1
                    # Go Left: 
                    elseif mod(Direction,4) == 2
                        Position_Row = reverse(Position_Row)
                        for i in 1:length(Position_Column)
                            matrix[Position_Row[1],Position_Column[i]] = number
                            number += 1  
                        end
                        popat!(Position_Row,1)
                        Direction += 1
                    # Go Up:
                    elseif mod(Direction,4) == 3
                        Position_Column = reverse(Position_Column)
                        for i in 1:length(Position_Row)
                            matrix[Position_Row[i],Position_Column[1]] = number
                            number += 1  
                        end
                        popat!(Position_Column,1)
                        Direction += 1
                    end
                end
                return matrix
            end
        end
        Spiral_Matrix(12,12)
# 21. Julia Set:
    # Using Package:
        using Plots
    # SO1:
        # Funciton Velocity:
            function escapeVelocity(Re,Im,c::Complex,N::Integer)
                z = Re + Im*im
                for Velocity in 1:N 
                    z = (z)^2 + c
                    if abs(z) > 2 #or sqrt((conj(z))*z) > 2
                        return Velocity
                        break
                    end
                end
            end

        # Function Julia:
            function Julia_set(c::Complex,N::Integer, zMax, Height, Width)
                matrix=[escapeVelocity(Re,Im,c,N) for Re in -zMax:((2*zMax+1)/Height):zMax, Im in -zMax:((2*zMax+1)/Width):zMax]
                heatmap(matrix)
            end
            # a.) Plot 1:
            Plot_1=Julia_set(-0.297491+0.641051*im,100,1,500,500)
            savefig(Plot_1,"Plot_1.png")
            # b.) Plot 2:
            Plot_2=Julia_set(-0.297491+0.641051*im,250,0.35,500,500)
            savefig(Plot_2,"Plot_2.png")
    
    # SO2:
        # Funciton Velocity:
            function escapeVelocity_2(z0,c::Complex,N::Integer)
                n = 0
                z = z0
                while (n ≤ N) && (abs(z) ≤ 2)
                        n = n + 1
                        z = z^2 + c
                end
                return n
            end

        # Function Julia:
            function Julia_set(c::Complex,N::Integer, zMax, Height, Width)
                matrix=[escapeVelocity_2(Re+Im*im,c,N) for Re in -zMax:((2*zMax+1)/Height):zMax, Im in -zMax:((2*zMax+1)/Width):zMax]
                heatmap(matrix)
            end
            # a.) Plot 1:
            Plot_1=Julia_set(-0.297491+0.641051*im,100,1,500,500)
            savefig(Plot_1,"Plot_1.png")
            # b.) Plot 2:
            Plot_2=Julia_set(-0.297491+0.641051*im,250,0.35,500,500)
            savefig(Plot_2,"Plot_2.png")

    # SO3:
        # Funciton Velocity:
            function escapeVelocity_3(z0,c::Complex,N::Integer)
                n = 0
                z = z0
                while (n ≤ N) && (abs(z) ≤ 2)
                        n = n + 1
                        z = z^2 + c
                end
                return n
            end

        # Function Julia:
            function julia(zMax, c, N=100)
                step = 2*zMax/500
                x = -zMax:step:zMax
                l = length(x)
                M = zeros(Int,l,l)
                for i=1:l
                    for j=1:l
                        z0 = complex(x[i], x[j])
                        M[i,j] = escapeVelocity_3(z0, c, N)
                    end
                end
                return M
            end
            z0 = complex(-0.297491, 0.641051)
            M = julia(1, z0, 100)
            heatmap(M)

# 22. Matrix Multiply:
    # SO1:
        function multiply(Matrix_1::Matrix,Matrix_2::Matrix)
            return Matrix_1*Matrix_2
        end
        multiply([1 0 0; 1 0 0], [1 2 3 4 5; 1 2 3 4 5; 1 2 3 4 5])
    
    # SO2:
        function multiply_2(Matrix_1::Matrix,Matrix_2::Matrix)
            size(Matrix_1,2)==size(Matrix_2,1) || error("The number of First Matrix's Columns have to equal to the number of Second Matrix's Rows")
            Multiply_Matrix = zeros(size(Matrix_1,1),size(Matrix_2,2)) #Or Array{Float64}(undef,size(Matrix_1,1),size(Matrix_2,2))
            for Row in 1:(size(Matrix_1,1))
                for Column in 1:(size(Matrix_2,2))
                    Multiply_Matrix[Row,Column]=sum(Matrix_1[Row,:].*Matrix_2[:,Column])
                end
            end
            return Multiply_Matrix
        end
        multiply_2([1 0 0; 1 0 0], [1 2 3 4 5; 1 2 3 4 5; 1 2 3 4 5])
    
    # SO3:
        function multiply_2_short(Matrix_1::Matrix,Matrix_2::Matrix)
            size(Matrix_1,2)==size(Matrix_2,1) || error("The number of First Matrix's Columns have to equal to the number of Second Matrix's Rows")
            [sum(Matrix_1[Row,:].*Matrix_2[:,Column]) for Row in 1:(size(Matrix_1,1)), Column in 1:(size(Matrix_2,2))]
        end
        multiply_2_short([1 0 0; 1 0 0], [1 2 3 4 5; 1 2 3 4 5; 1 2 3 4 5])
        
    # SO4:
        function multiply_3(Matrix_1::Matrix,Matrix_2::Matrix)
            Matrix_Result = zeros(size(Matrix_1,1),size(Matrix_2,2))
            for Row in 1:(size(Matrix_1,1))
                for Column in 1:(size(Matrix_2,2))
                    Matrix_Sum = 0
                    # Dot product for Row i: 
                    for Postion in 1:(size(Matrix_1,2)) #Or size(Matrix_2,2)
                        Matrix_Sum = Matrix_Sum + Matrix_1[Row,Postion]*Matrix_2[Postion,Column] 
                    end
                    Matrix_Result[Row, Column] = Matrix_Sum
                end
            end
            return Matrix_Result
        end
        multiply_3([1 0 0; 1 0 0], [1 2 3 4 5; 1 2 3 4 5; 1 2 3 4 5])

# 23. Magic Square:
    # SO1: 
        function Magic_Square(Size::Integer,Number::Integer = 1)
            Size > 2 || error("Square Matrix must have size greater than 2x2")
            # Generate an Undef Matrix:
            Undef_Matrix = [0 for Row in 1:Size, Column in 1:Size] #Or zeros(Size,Size)
            # Fill Undef Matrix:
            Row = 1
            Column = round(Integer,(Size+1)/2)
            if isodd(Size) # For Odd Square:
                for time in 1:(Size^2)
                    if (Row > 0) && (Column <= Size)
                        if Undef_Matrix[Row,Column] == 0
                            Undef_Matrix[Row, Column] = Number
                        else
                            Row += 2
                            Column -= 1 
                            Undef_Matrix[Row, Column] = Number
                        end
                    elseif (Row > 0) && (Column > Size)
                        Column = 1
                        if Undef_Matrix[Row,Column] == 0
                            Undef_Matrix[Row, Column] = Number
                        else
                            Row += 2
                            Column -= 1 
                            Undef_Matrix[Row, Column] = Number
                        end
                    elseif (Row == 0) && (Column <= Size)
                        Row = Size
                        if Undef_Matrix[Row,Column] == 0
                            Undef_Matrix[Row, Column] = Number
                        else
                            Row += 2
                            Column -= 1 
                            Undef_Matrix[Row, Column] = Number
                        end
                    else
                        Row += 2
                        Column -= 1
                        if Undef_Matrix[Row,Column] == 0
                            Undef_Matrix[Row, Column] = Number
                        else
                            Row += 2
                            Column -= 1 
                            Undef_Matrix[Row, Column] = Number
                        end 
                    end
                    Row -= 1
                    Column += 1 
                    Number += 1
                end
                return Undef_Matrix
            else #For Even Square:
                if mod(Size,4) != 0 # Even Square have length a side divisible by 2 not 4 (Singly Even Matrix):  
                    Size_SmallMatrix = Int(sqrt(Size^2/4))
                    A = Magic_Square(Size_SmallMatrix,1)
                    B = Magic_Square(Size_SmallMatrix,(Size_SmallMatrix)^2+1)
                    C = Magic_Square(Size_SmallMatrix,2*(Size_SmallMatrix)^2+1)
                    D = Magic_Square(Size_SmallMatrix,3*(Size_SmallMatrix)^2+1)
                    # Transition A and D at Column i:
                    Midpoint = Int((sqrt(Size^2/4)+1)/2)
                    for i in 1:Int((Size_SmallMatrix-1)/2)
                        A[:,i] = D[:,i] - A[:,i] 
                        D[:,i] = D[:,i] - A[:,i]
                        A[:,i] = D[:,i] + A[:,i]
                    end
                    # Transition A and D at Middle Column 1:
                    A[Midpoint,1] = D[Midpoint,1] - A[Midpoint,1] 
                    D[Midpoint,1] = D[Midpoint,1] - A[Midpoint,1]
                    A[Midpoint,1] = D[Midpoint,1] + A[Midpoint,1]
                    # Transition A and D at Middle:
                    A[Midpoint,Midpoint] = D[Midpoint,Midpoint] - A[Midpoint,Midpoint] 
                    D[Midpoint,Midpoint] = D[Midpoint,Midpoint] - A[Midpoint,Midpoint]
                    A[Midpoint,Midpoint] = D[Midpoint,Midpoint] + A[Midpoint,Midpoint]
                    # Transition C and B at Column i:
                    Number_Column = Int(((Size_SmallMatrix-1)/2)-1)
                    for i in 1:Number_Column
                        C[:,Size_SmallMatrix+1-i] = B[:,Size_SmallMatrix+1-i] - C[:,Size_SmallMatrix+1-i] 
                        B[:,Size_SmallMatrix+1-i] = B[:,Size_SmallMatrix+1-i] - C[:,Size_SmallMatrix+1-i]
                        C[:,Size_SmallMatrix+1-i] = B[:,Size_SmallMatrix+1-i] + C[:,Size_SmallMatrix+1-i]
                    end
                    return [A C; D B]
                else # Even Square have length a side divisible by 4 (Double Even Matrix):
                    # Generate Undef Matrix:
                    Undef_Matrix = zeros(Int,Size,Size)
                    # Fill Undef Matrix with 1 to 16:
                    for Row in 1:Size 
                        for Column in 1:Size
                            Undef_Matrix[Row,Column] = Number
                            Number += 1
                        end
                    end
                    # Coefficient:
                    Number = Number - 1
                    Rules_1 = 1 # Change Row. 
                    Rule = 0 # Change Column. 
                    Rules_2 = 0 # Change Row.
                    Row = 1 
                    Column = 1 
                    # Transition:
                    for Repeat in 1:Size
                        if mod(Rule,4) == 0
                            for i in 1:(Size/2) # Size/2 is the column need to be filled after the Rule change.
                                Undef_Matrix[Row,Column] = Number
                                if mod(Rules_1,2) == 1
                                    Number -= 3
                                    Column += 3
                                else
                                    Number -= 1 
                                    Column += 1
                                end
                                Rules_1 += 1
                            end
                            Column = 2 
                            Row += 1
                            Rule += 1
                            Rules_1 = 1
                            Number -= 1
                        elseif mod(Rule,4) == 1
                            for i in 1:(Size/2)
                                Undef_Matrix[Row,Column] = Number
                                if mod(Rules_2,2) == 1
                                    Number -= 3
                                    Column += 3
                                else
                                    Number -= 1 
                                    Column += 1
                                end
                                Rules_2 += 1
                            end
                            Column = 2 
                            Row += 1
                            Rule += 1
                            Rules_2 = 0
                        elseif mod(Rule,4) == 2
                            for i in 1:(Size/2)
                                Undef_Matrix[Row,Column] = Number
                                if mod(Rules_2,2) == 1
                                    Number -= 3
                                    Column += 3
                                else
                                    Number -= 1 
                                    Column += 1
                                end
                                Rules_2 += 1
                            end
                            Column = 1 
                            Row += 1
                            Rule += 1
                            Rules_2 = 0
                            Number += 1
                        else
                            for i in 1:(Size/2)
                                Undef_Matrix[Row,Column] = Number
                                if mod(Rules_1,2) == 1
                                    Number -= 3
                                    Column += 3
                                else
                                    Number -= 1 
                                    Column += 1
                                end
                                Rules_1 += 1
                            end
                            Column = 1 
                            Row += 1
                            Rule += 1
                            Rules_1 = 1
                        end
                    end
                    return Undef_Matrix
                end
            end
        end
        Magic_Square(9)
        
    # Check if is Magic Square (Just for fun):
        function IsMagicSquare(matrix::Matrix)
            # Sum:
            Size = size(matrix,1) # Is a Square matrix so check for one dims is enough.
            Sum = (Size*(Size^2+1))/2 
            Row = [sum(matrix[position,:]) for position in 1:Size] 
            Column = [sum(matrix[:,position]) for position in 1:Size] 
            Main_Diagonal = sum([matrix[position,position] for position in 1:Size])
            Second_Diagonal = sum([matrix[position,Size+1-position] for position in 1:Size])
            # Boolen:
            BoolenVector_R = (Row .!= Sum)
            BoolenVector_C = (Column .!= Sum)
            # Compare:
            if (Row[BoolenVector_R] != Any[]) || (Column[BoolenVector_C] != Any[]) || (Main_Diagonal != Sum) || (Second_Diagonal != Sum)
                return false
            else
                return true
            end
        end
        IsMagicSquare(Magic_Square(10))

# 24. Is Subset ? :
    # SO1:
        function is_Subset(Array_1,Array_2)
            if length(Array_1) <= length(Array_2)
                # Find different values in Array 1:
                DValues_1 = unique(Array_1) 
                # Number of that value in Array 1:
                Data_set = []
                for position in 1:length(DValues_1)
                    push!(Data_set,(DValues_1[position],length(Array_1[Array_1 .== DValues_1[position]])))
                end
                # Compare Values Array_1 with Array_2:
                for position in 1:length(DValues_1)
                    if length(Array_2[Array_2 .== Data_set[position][1]]) < Data_set[position][2]
                        return false
                        break
                    end
                end
                return true
            else
                # Find different values in Array 2:
                DValues_2 = unique(Array_2) 
                # Number of that value in Array 2:
                Data_set = []
                for position in 1:length(DValues_2)
                    push!(Data_set,(DValues_2[position],length(Array_2[Array_2 .== DValues_2[position]])))
                end
                # Compare Values Array_2 with Array_1:
                for position in 1:length(DValues_2)
                    if length(Array_1[Array_1 .== Data_set[position][1]]) < Data_set[position][2]
                        return false
                        break
                    end
                end
                return true 
            end
        end
        is_Subset([1,2],[1])

    # SO2:
        function is_Subset2(Array_1,Array_2)
            for x in Array_1
                if x ∉ Array_2
                    return false
                    break
                end
            end
            return true
        end
        is_Subset2([1,2,3],[1,2,3,4])

# 25. Sort Array Values:
    # SO1:
        function Values_Times(Array)
            # Copy Array:
            CArray = Array 
            # Filter Values:
            Unique_Vector = []
            while true
                if length(CArray) != 0
                    push!(Unique_Vector , CArray[1])
                    CArray = CArray[CArray .!= CArray[1]]
                else 
                    break
                end
            end # Or use unique(Array)
            # Find number of times the value repeated:
            Data_Values = []
            for position in 1:length(Unique_Vector)
                push!(Data_Values,(Unique_Vector[position],length(Array[Array .== Unique_Vector[position]])))
            end
            # Sort Data Values:
            Data_Values = sort(Data_Values)
            # Print:
            for Values in Data_Values 
                println("Number of time ",Values[1]," appear:",Values[2])                
            end
        end
        Values_Times(rand(1:100,100000))

# 26. The sieve of Eratosthenes for Prime Numbers:
    # SO1:
        iscoprime(P, i) = !any(x -> i % x == 0, P)
        function sieve(n)
            P = Int[]
            for i in 2:n
                if iscoprime(P, i)
                    push!(P, i)
                end
            end
            return P
        end
        sieve(10)
        
    # SO2:
        function sieve2(n)
            Vector = [x for x in 2:n]
            Position = [true for x in 2:n] # Or use BitVector([1 for x in 2:n])
            p = 2
            while p^2 <= n
                for p_1 in (p^2-1):p:(n-1) 
                    Position[p_1] = false    
                end 
                p += 1       
            end
            return Vector[Position]
        end
        sieve2(100)

# 27. Write a program to visualize a two-variable function in predefined ranges of x and y:
    # Use Package:
        using Plots
    # SO1:
        function Graph3D(xStart,xStop,yStart,yStop,Length,f)
            x = range(xStart,stop = xStop,length = Length)
            y = range(yStart,stop = yStop,length = Length)  
            plot(
                x,
                y,
                f,
                title=string("Draw a nice hat"),
                xlabel="x",
                ylabel="y",
                label= false,
                gridalpha=0.5,
                gridstyle=:dash,
                minorgrid=true,
                c = cgrad([:red,:blue]),
                st = :surface
            )          
        end
        Plot_3 = Graph3D(-6,6,-6,6,100,(x,y)->((sin(sqrt(x^2+y^2)))/(sqrt(x^2+y^2))))
        savefig(Plot_3,"Plot_3.png")
        
# 28. A square matrix of size n is singular if its determinant is zero, or equivalently, its rank is less than n. Suppose that you are given a random matrix whose values are uniformly distributed in the range [0,1]. Investigate the singularity behaviour of such matrieces as n increases.
    # SO1:
# 29. Symmetric - palindrome string:
    # SO1:
        function isSymmetricPalindrom(str::String)
            # Remove special characters:
            Remove_Char = "!#$%&'()*+,-./:;<=>?@[]^_`{|}~ " # Or filter(x->x ∉ Remove_Char, str)
            for letter in str
                if letter in Remove_Char
                    str = replace(str, letter => "") # Or filter(x -> x != letter, str)
                end
            end
            # Check:
            if isodd(length(str))
                # Check for Symmetric:
                # Split text:
                First_half = str[begin:div(length(str)+1,2)]
                Last_half = str[div(length(str)+1,2):end]
                word_check_S = 0
                for position in 1:length(First_half) # Or length(Last_half)
                    if  First_half[position] != Last_half[position]
                        println("The string is not Symmetric")
                        break
                    end
                    word_check_S+= 2
                end

                # Check for Palindrome:
                First_half = str[begin:div(length(str),2)]
                Last_half = str[div(length(str),2)+2:end]
                word_check_P = 0 
                for position in 1:length(First_half)# Or length(Last_half)
                    if  First_half[position] != Last_half[length(First_half) + 1 - position]
                        println("The string is not Palindrome")
                        break
                    end
                    word_check_P += 2
                end

                # Conclude:
                if word_check_S == length(str) + 1
                    println("The string is Symmetric")
                end
                if word_check_P == length(str) - 1
                    println("The string is Palindrome")
                end
            else
                # Check for Symmetric:
                # Split text:
                First_half = str[begin:div(length(str)+1,2)]
                Last_half = str[div(length(str)+1,2)+1:end]
                word_check_S = 0
                for position in 1:length(First_half) # Or length(Last_half)
                    if  First_half[position] != Last_half[position]
                        println("The string is not Symmetric")
                        break
                    end
                    word_check_S+= 2
                end

                # Check for Palindrome:
                word_check_P = 0 
                for position in 1:length(First_half)# Or length(Last_half)
                    if  First_half[position] != Last_half[length(First_half) + 1 - position]
                        println("The string is not Palindrome")
                        break
                    end
                    word_check_P += 2
                end

                # Conclude:
                if word_check_S == length(str) 
                    println("The string is Symmetric")
                end
                if word_check_P == length(str)
                    println("The string is Palindrome")
                end
            end
        end
        isSymmetricPalindrom("madam i'm adam")
    
    # SO2:
        function isSymmetricPalindrom(str::String)
            # Remove special characters:
            strip(str,[",",".","?","!",":",";","'"." "])
        end
# 30. Frequence 
    # SO1:
        function Letter_Frequence(str::String)
            # Unique letter:    
            Letter_Vector = []
            for letter in str #Or unique(str)
                if letter ∉ Letter_Vector
                    push!(Letter_Vector,letter)
                end
            end   
            # Frequence:
            Letter_Frequence = []
            for letter in Letter_Vector 
                times = 0
                for letter_1 in str
                    if letter == letter_1
                        times += 1 
                    end
                end
                push!(Letter_Frequence,(letter,times))
            end
            # Return:
            for Values in Letter_Frequence
                println("Number of time ",Values[1]," appear:",Values[2])                
            end
        end
        Letter_Frequence("qwkerq ")
    
    # SO2:
        function Letter_Frequence_2(str::String)
            # Unique letter:    
            Letter_Vector = unique(str)
            # Frequence:
            Letter_Frequence = []
            for letter in Letter_Vector 
                times = 1
                p_first_letter = findfirst(letter,str)
                p_last_letter = findlast(letter,str)
                p_letter = p_first_letter
                while p_letter[1] != p_last_letter[1]
                    p_letter = findnext(letter, str, p_letter[1]+1)
                    times += 1 
                end
                push!(Letter_Frequence,(letter,times))
            end
            # Return:
            for Values in Letter_Frequence
                println("Number of time ",Values[1]," appear:",Values[2])                
            end
        end
        Letter_Frequence_2("qqqq")

# 31. Switch Position:
    # SO1:
        function Switch(a,b)
            a = a + b
            b = a - b 
            a = a - b 
            print("a =",a,"\nb =", b)
        end
        Switch(1,2)

    # SO2:
        function Switch_2(a,b)
            c = a
            a = b
            b = c
            print_2("a =",a,"\nb =", b)
        end
        Switch(1,2)

# 32. Sort Array:
    # SO1:
        function Sort_Array(Array)
            for i in 1:length(Array)
                for j in i+1:length(Array) 
                    if Array[i] > Array[j]
                        Array[i] = Array[i] + Array[j]
                        Array[j] = Array[i] - Array[j]
                        Array[i] = Array[i] - Array[j]
                    end
                end 
            end
            return Array
        end
        Sort_Array(rand(1:20,1,100))
    
    # SO2 (Bubble Sort):
        function Sort(Array)
            for time in 1:length(Array)-1
                for pos in 1:(length(Array)-time)
                    if Array[pos] > Array[pos+1]
                        Array[pos] = Array[pos] + Array[pos+1]
                        Array[pos+1] = Array[pos] - Array[pos+1]
                        Array[pos] = Array[pos] - Array[pos+1]
                    end
                end
            end
            return Array
        end
        Sort(rand(1:10,10))

    # SO3 (Max Sort):

# 33. Index Increase Max Length Sub:
    # SO1:
        function indexMax(Array)
            res = [1]
            for i in 2:length(Array) 
                a = 1
                for j in 1:(i-1)
                    if Array[i] > Array[j]
                        if res[j] + 1 > a
                            a = res[j] +1
                        end
                    end
                end
                push!(res,a)
            end
            return res
        end
        indexMax([5,6,7,1,2,3,4,5])

    # SO2:
        function indexMax2(Array)
            C_Array = Array
            pos_1 = findall(isequal(1),C_Array)
            pos_sub = 1
            while 
                pos_max = findall(isequal(maximum(C_Array)),C_Array)
                C_Array[pos_max] = [pos_sub for i in 1:length(pos_max)]
            end 
        end

# 34. Length Sub-Array Max:
    # SO1:  
        function SubMax_1(Array)
            res = [1]
            values = 1 
            pos = 1
            for i in 2:length(Array) 
                a = 1

                for j in 1:(i-1)
                    if Array[i] > Array[j]
                        if res[j] + 1 > a
                            a = res[j] +1
                        end
                    end
                end
                push!(res,a)

                if a > values
                    values = a
                    pos = i
                end
            end

            return Array[pos-values+1:pos]
        end
        SubMax_1([5,6,6,6,7,1,2,3,4,5])

# 35. Sum of Digits:
    # SO1:
        function SOD(Number::Integer)
            sum = 0
            for i in string(Number)
                sum += parse(Int,i)
            end
            return sum
        end
        SOD(rand(1:10000))

    # SO2:
        function SOD1(Number::Integer)
            sum = 0
            for i in 1:(trunc(Int,log10(Number))+1)  
                sum += ((Number/10)-div(Number,10))*10
                Number = div(Number,10)
            end
            return trunc(Int,sum)
        end
        SOD1(123859845646)
        
    # SO3:
        function SOD2(Number::Integer)
            sum = 0
            for i in 1:floor(log10(Number*10)) 
                sum += mod(Number,10) 
                Number = div(Number,10) 
            end
            return sum
        end
        SOD2(0)