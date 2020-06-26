package by.epam.dedik.day4.entity;

import by.epam.dedik.day4.service.Comparison;

public enum ComparisonRule {
    ASCENDING((a, b) -> a < b),
    DESCENDING((a, b) -> a > b);

    private Comparison comparison;

    ComparisonRule(Comparison comparison) {
        this.comparison = comparison;
    }

    public Comparison getComparison() {
        return comparison;
    }
}
