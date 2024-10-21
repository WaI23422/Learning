import random

def reconstruct_secret(shares):
    """
    Combines individual list of points (x, y) belonging to a polynomial 
    with a constant of our key using Lagrange's interpolation.
    """
    secret = 0

    for j, (xj, yj) in enumerate(shares):
        prod = 1

        for i, (xi, _) in enumerate(shares):
            if i != j:
                prod *= (0 - xi) / (xj - xi)

        secret += prod * yj

    return round(secret)


def polynom(x, coefficients):
    """
    This generates a single point on the graph of a given polynomial
    in `x`. The polynomial is given by the list of `coefficients`.
    """
    point = 0
    # Loop through reversed list, so that indices from enumerate match the
    # actual coefficient indices
    for coefficient_index, coefficient_value in enumerate(coefficients[::-1]):
        point += x ** coefficient_index * coefficient_value
    return point


def coeff(t, secret):
    """
    Randomly generate a list of coefficients for a polynomial with
    a degree of `t` - 1, whose constant is `secret`.
    """
    coeff = [random.randrange(1, 10**5) for _ in range(t - 1)]
    coeff.append(secret)
    return coeff


def generate_shares(n, m, secret):
    """
    Split given `secret` into `n` shares with a minimum threshold
    of `m` shares to recover this `secret`, using SSS algorithm.
    """
    coefficients = coeff(m, secret)
    shares = []

    for _ in range(n):
        x = random.randrange(1, 10**5)
        shares.append((x, polynom(x, coefficients)))

    return shares


# Driver code
if __name__ == '__main__':
    # (3, 5) sharing scheme
    t, n = 3, 5
    secret = 1234
    print(f'Original Secret: {secret}')

    # Phase I: Generation of shares
    shares = generate_shares(n, t, secret)
    print(f'Shares: {", ".join(str(share) for share in shares)}')

    # Phase II: Secret Reconstruction
    # Picking t shares randomly for
    # reconstruction
    pool = random.sample(shares, t)
    print(f'Combining shares: {", ".join(str(share) for share in pool)}')
    print(f'Reconstructed secret: {reconstruct_secret(pool)}')
