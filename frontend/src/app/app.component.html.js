--The;
content;
below;
is;
only;
a;
placeholder;
and;
can;
be;
replaced.-- >
    -toolbar;
color = "primary" >
    {};
{
    title;
}
/span>
    < span;
var default_1 = /** @class */ (function () {
    function default_1() {
    }
    return default_1;
}());
"spacer" > /span>
    < /mat-toolbar>
    < div;
style = "text-align:center" >
    {};
{
    desc;
}
/h1>
    < /div>
    < nav;
mat - tab - nav - bar >
    mat - tab - link
        * ngFor;
"let link of navLinks"[routerLink] = "link.path";
routerLinkActive;
rla = "routerLinkActive" >
    {};
{
    link.label;
}
/a>
    < /nav>
    < router - outlet > /router-outlet>;
