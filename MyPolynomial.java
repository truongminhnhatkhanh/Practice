package chuong3;
import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = Arrays.copyOf(coeffs, coeffs.length);
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = getDegree(); i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (i != getDegree()) {
                    sb.append(coeffs[i] >= 0 ? " + " : " - ");
                }
                sb.append(Math.abs(coeffs[i]));
                if (i > 0) {
                    sb.append("x");
                    if (i > 1) {
                        sb.append("^").append(i);
                    }
                }
            }
        }
        return sb.toString();
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i <= getDegree(); i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxDegree = Math.max(this.getDegree(), right.getDegree());
        double[] resultCoeffs = new double[maxDegree + 1];

        for (int i = 0; i <= maxDegree; i++) {
            if (i <= this.getDegree()) {
                resultCoeffs[i] += this.coeffs[i];
            }
            if (i <= right.getDegree()) {
                resultCoeffs[i] += right.coeffs[i];
            }
        }
        return new MyPolynomial(resultCoeffs);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] resultCoeffs = new double[this.getDegree() + right.getDegree() + 1];

        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= right.getDegree(); j++) {
                resultCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        return new MyPolynomial(resultCoeffs);
    }

}

