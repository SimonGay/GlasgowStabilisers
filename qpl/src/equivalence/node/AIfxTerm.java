/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class AIfxTerm extends PTerm
{
    private TIf _if_;
    private TId _cond_;
    private TThen _then_;
    private TX _x_;
    private TLparen _lparen_;
    private TId _target_;
    private TRparen _rparen_;
    private PSep _sep_;
    private PTerm _term_;

    public AIfxTerm()
    {
        // Constructor
    }

    public AIfxTerm(
        @SuppressWarnings("hiding") TIf _if_,
        @SuppressWarnings("hiding") TId _cond_,
        @SuppressWarnings("hiding") TThen _then_,
        @SuppressWarnings("hiding") TX _x_,
        @SuppressWarnings("hiding") TLparen _lparen_,
        @SuppressWarnings("hiding") TId _target_,
        @SuppressWarnings("hiding") TRparen _rparen_,
        @SuppressWarnings("hiding") PSep _sep_,
        @SuppressWarnings("hiding") PTerm _term_)
    {
        // Constructor
        setIf(_if_);

        setCond(_cond_);

        setThen(_then_);

        setX(_x_);

        setLparen(_lparen_);

        setTarget(_target_);

        setRparen(_rparen_);

        setSep(_sep_);

        setTerm(_term_);

    }

    @Override
    public Object clone()
    {
        return new AIfxTerm(
            cloneNode(this._if_),
            cloneNode(this._cond_),
            cloneNode(this._then_),
            cloneNode(this._x_),
            cloneNode(this._lparen_),
            cloneNode(this._target_),
            cloneNode(this._rparen_),
            cloneNode(this._sep_),
            cloneNode(this._term_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIfxTerm(this);
    }

    public TIf getIf()
    {
        return this._if_;
    }

    public void setIf(TIf node)
    {
        if(this._if_ != null)
        {
            this._if_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._if_ = node;
    }

    public TId getCond()
    {
        return this._cond_;
    }

    public void setCond(TId node)
    {
        if(this._cond_ != null)
        {
            this._cond_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._cond_ = node;
    }

    public TThen getThen()
    {
        return this._then_;
    }

    public void setThen(TThen node)
    {
        if(this._then_ != null)
        {
            this._then_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._then_ = node;
    }

    public TX getX()
    {
        return this._x_;
    }

    public void setX(TX node)
    {
        if(this._x_ != null)
        {
            this._x_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._x_ = node;
    }

    public TLparen getLparen()
    {
        return this._lparen_;
    }

    public void setLparen(TLparen node)
    {
        if(this._lparen_ != null)
        {
            this._lparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._lparen_ = node;
    }

    public TId getTarget()
    {
        return this._target_;
    }

    public void setTarget(TId node)
    {
        if(this._target_ != null)
        {
            this._target_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._target_ = node;
    }

    public TRparen getRparen()
    {
        return this._rparen_;
    }

    public void setRparen(TRparen node)
    {
        if(this._rparen_ != null)
        {
            this._rparen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rparen_ = node;
    }

    public PSep getSep()
    {
        return this._sep_;
    }

    public void setSep(PSep node)
    {
        if(this._sep_ != null)
        {
            this._sep_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._sep_ = node;
    }

    public PTerm getTerm()
    {
        return this._term_;
    }

    public void setTerm(PTerm node)
    {
        if(this._term_ != null)
        {
            this._term_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._term_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._if_)
            + toString(this._cond_)
            + toString(this._then_)
            + toString(this._x_)
            + toString(this._lparen_)
            + toString(this._target_)
            + toString(this._rparen_)
            + toString(this._sep_)
            + toString(this._term_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._if_ == child)
        {
            this._if_ = null;
            return;
        }

        if(this._cond_ == child)
        {
            this._cond_ = null;
            return;
        }

        if(this._then_ == child)
        {
            this._then_ = null;
            return;
        }

        if(this._x_ == child)
        {
            this._x_ = null;
            return;
        }

        if(this._lparen_ == child)
        {
            this._lparen_ = null;
            return;
        }

        if(this._target_ == child)
        {
            this._target_ = null;
            return;
        }

        if(this._rparen_ == child)
        {
            this._rparen_ = null;
            return;
        }

        if(this._sep_ == child)
        {
            this._sep_ = null;
            return;
        }

        if(this._term_ == child)
        {
            this._term_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._if_ == oldChild)
        {
            setIf((TIf) newChild);
            return;
        }

        if(this._cond_ == oldChild)
        {
            setCond((TId) newChild);
            return;
        }

        if(this._then_ == oldChild)
        {
            setThen((TThen) newChild);
            return;
        }

        if(this._x_ == oldChild)
        {
            setX((TX) newChild);
            return;
        }

        if(this._lparen_ == oldChild)
        {
            setLparen((TLparen) newChild);
            return;
        }

        if(this._target_ == oldChild)
        {
            setTarget((TId) newChild);
            return;
        }

        if(this._rparen_ == oldChild)
        {
            setRparen((TRparen) newChild);
            return;
        }

        if(this._sep_ == oldChild)
        {
            setSep((PSep) newChild);
            return;
        }

        if(this._term_ == oldChild)
        {
            setTerm((PTerm) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
