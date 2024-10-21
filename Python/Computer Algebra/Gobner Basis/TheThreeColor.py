from sympy import symbols, groebner, solve

def generate_polynomials(graph, colors):
    """
    Generate polynomial with number of graph and number of vertex need to be color 
    """
    polynomials = []
    for vertex, neighbors in graph.items():
        poly1 = colors[vertex]**3
        polynomials.append(poly1 - 1)
        for neighbor in neighbors:
            poly2 = colors[vertex]**2 + colors[vertex] * colors[neighbor] + colors[neighbor]**2
            polynomials.append(poly2)

    return polynomials

def groebner_color(graph):
    """
    Applied reduced Groebner bases for graph. 
    """
    num_vertices = len(graph)
    colors = symbols('x:{}'.format(num_vertices + 1))

    polynomials = generate_polynomials(graph, colors)
    groebner_basis = groebner(polynomials)

    # Solve the system of equations
    return groebner_basis
    
# Example graph: {1: [2, 3]} | 1: [2,3] means Vertex 1 connects to 2 and 3.
# 3-NonColorable graph:
graph = {1: [2, 4, 5], 2: [1, 3, 6], 3: [2, 4, 6 , 7], 4: [1, 3, 7], 5: [1, 4, 6, 7], 6: [2, 3, 5, 7], 7: [3, 4, 5, 6]}

coloring = groebner_color(graph)

# Condition of groebner bases if the graph is 3-colorable
if 1 not in coloring:
    print("Graph is 3-colored:")
    print(coloring)
else:
    print("Graph cannot be 3-colored.")
    print(coloring)

# 3-Colorable graph:
graph = {1: [2, 4, 5], 2: [1, 3, 6], 3: [2, 4, 6 , 7], 4: [1, 3, 7], 5: [1, 4, 6, 7], 6: [2, 3, 5], 7: [3, 4, 5]}

coloring = groebner_color(graph)

# Condition of groebner bases if the graph is 3-colorable
if 1 not in coloring:
    print("Graph is 3-colored:")
    print(coloring)
else:
    print("Graph cannot be 3-colored.")
    print(coloring)