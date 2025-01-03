package Logic;

public class Fractal {
    //the function used in the definition of the Mandelbrot set Zn+1 = (Zn)^2 + C
    public static ComplexNumber fractalEquation(ComplexNumber previous, ComplexNumber input) {
        ComplexNumber previousSquared = ComplexNumber.square(previous);
        return ComplexNumber.add(previousSquared, input);
    }

    //Checks if a complex number is in the fractal
    //returns -1 if the number is in the set
    //otherwise it returns the number of iterations it took to get out of radius 2 for colouring purposes later
    public static int isInJuliaFractal(ComplexNumber input,ComplexNumber julia, int iterations) {
        ComplexNumber previous = input;
        for (int i = 0; i < iterations; i++) {
            ComplexNumber current = fractalEquation(previous, julia);
            if (!validMagnitude(current)) {
                return i;
            }
            previous = current;
        }
        return -1;
    }

    //Checks if a complex number is in the fractal
    //returns -1 if the number is in the set
    //otherwise it returns the number of iterations it took to get out of radius 2 for colouring purposes later
    public static int isInMandelbrotFractal(ComplexNumber input, int iterations) {
        ComplexNumber previous = new ComplexNumber();
        for (int i = 0; i < iterations; i++) {
            ComplexNumber current = fractalEquation(previous, input);
            if (!validMagnitude(current)) {
                return i;
            }
            previous = current;
        }
        return -1;
    }
    // If a complex number that is being operated on ever moves outside the radius 2, then it is not in the mandelbrot set
    public static boolean validMagnitude(ComplexNumber input) {
        if (ComplexNumber.magnitude(input) > 2) {
            return false;
        } else {
            return true;
        }
    }
}
