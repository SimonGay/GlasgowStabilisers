/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class TMeasure extends Token
{
    public TMeasure()
    {
        super.setText("measure");
    }

    public TMeasure(int line, int pos)
    {
        super.setText("measure");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TMeasure(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTMeasure(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TMeasure text.");
    }
}