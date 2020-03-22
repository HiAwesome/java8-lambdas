package com.moqi.c05;

@SuppressWarnings("ALL")
public class C05P078StringCombiner {

    private final String prefix;
    private final String suffix;
    private final String delim;
    private final StringBuilder buIlder;

    public C05P078StringCombiner(String delim, String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.delim = delim;
        this.buIlder = new StringBuilder();
    }

    // BEGIN add
    public C05P078StringCombiner add(String word) {
        if (!this.areAtStart()) {
            this.buIlder.append(delim);
        }
        this.buIlder.append(word);

        return this;
    }
    // END add

    // BEGIN merge
    public C05P078StringCombiner merge(C05P078StringCombiner other) {
        if (!other.equals(this)) {
            if (!other.areAtStart() && !this.areAtStart()) {
                other.buIlder.insert(0, this.delim);
            }
            this.buIlder.append(other.buIlder);
        }
        return this;
    }
    // END merge

    // BEGIN toString
    @Override
    public String toString() {
        return prefix + buIlder.toString() + suffix;
    }
    // END toString

    // BEGIN areAtStart
    private boolean areAtStart() {
        return buIlder.length() == 0;
    }
    // END areAtStart
}
