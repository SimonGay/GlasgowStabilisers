/* This file was generated by SableCC (http://www.sablecc.org/). */

package equivalence.node;

import equivalence.analysis.*;

@SuppressWarnings("nls")
public final class APrintTerm extends PTerm
{
    private TPrint _print_;
    private TId _id_;
    private PSep _sep_;
    private PTerm _term_;

    public APrintTerm()
    {
        // Constructor
    }

    public APrintTerm(
        @SuppressWarnings("hiding") TPrint _print_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") PSep _sep_,
        @SuppressWarnings("hiding") PTerm _term_)
    {
        // Constructor
        setPrint(_print_);

        setId(_id_);

        setSep(_sep_);

        setTerm(_term_);

    }

    @Override
    public Object clone()
    {
        return new APrintTerm(
            cloneNode(this._print_),
            cloneNode(this._id_),
            cloneNode(this._sep_),
            cloneNode(this._term_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPrintTerm(this);
    }

    public TPrint getPrint()
    {
        return this._print_;
    }

    public void setPrint(TPrint node)
    {
        if(this._print_ != null)
        {
            this._print_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._print_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
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
            + toString(this._print_)
            + toString(this._id_)
            + toString(this._sep_)
            + toString(this._term_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._print_ == child)
        {
            this._print_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
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
        if(this._print_ == oldChild)
        {
            setPrint((TPrint) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
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