// Used by ldc4 for classweb album!
// JavaScript Document
window.onerror = new Function("return true");
var obj = [];
var scr;
var spa;
var img;
var W;
var Wi;
var Hi;
var wi;
var hi;
var Sx;
var Sy;
var M;
var xm;
var ym;
var xb = 0;
var yb = 0;
var ob =  - 1;
var cl = false;

/* needed in standard mode */
px = function(x)
{
	return Math.round(x) + "px";
}

//////////////////////////////////////////////////////////
var Nx = 4; //size grid x
var Ny = picNum/4; //size grid y
var Tx = 4; // image width
var Ty = 4; // image height
var Mg = 40; // margin
var SP = 0.5; // speed
//////////////////////////////////////////////////////////

function Cobj(o, x, y)
{
	this.o = o;
	this.ix = Math.min(Nx - Tx, Math.max(0, Math.round(x - (Tx / 2))));
	this.iy = Math.min(Ny - Ty, Math.max(0, Math.round(y - (Ty / 2))));
	this.li = ((this.ix * M + this.ix * Sx) - (x * M + x * Sx)) / SP;
	this.ti = ((this.iy * M + this.iy * Sy) - (y * M + y * Sy)) / SP;
	this.l = 0;
	this.t = 0;
	this.w = 0;
	this.h = 0;
	this.s = 0;
	this.mv = false;
	this.spa = spa[o].style;
	this.img = img[o];
	this.txt = img[o].alt;
	img[o].alt = "";

	/* zooming loop */
	this.zoom = function()
	{
		with(this)
		{
			l += li * s;
			t += ti * s;
			w += wi * s;
			h += hi * s;
			if ((s > 0 && w < Wi) || (s < 0 && w > Sx))
			{
				/* force window.event */
				window.focus();
				/* loop */
				setTimeout("obj[" + o + "].zoom()", 16);
			}
			else
			{
				/* finished */
				mv = false;
				/* set final position */
				if (s > 0)
				{
					l = ix * M + ix * Sx;
					t = iy * M + iy * Sy;
					w = Wi;
					h = Hi;
				}
				else
				{
					l = x * M + x * Sx;
					t = y * M + y * Sy;
					w = Sx;
					h = Sy;
				}
			}
			/* html animation */
			with(spa)
			{
				left = px(l);
				top = px(t);
				width = px(w);
				height = px(h);
				zIndex = Math.round(w);
			}
		}
	}

	this.click = function()
	{
		with(this)
		{
			/* zooming logic */
			if ( ! mv || cl)
			{
				if (s > 0)
				{
					if (cl || Math.abs(xm - xb) > Sx * .4 || Math.abs(ym - yb) > Sy * .4)
					{
						s =  - 2;
						mv = true;
						zoom();
						cap.innerHTML = txt;
					}
				}
				else
				{
					if (cl || ob != o)
					{
						if (ob >= 0)
						{
							with(obj[ob])
							{
								s =  - 2;
								mv = true;
								zoom();
							}
						}
						ob = o;
						s = 1;
						xb = xm;
						yb = ym;
						mv = true;
						zoom();
						cap.innerHTML = txt;
					}
				}
			}
		}
	}
	
	/* hook up events */
	img[o].onmouseover = img[o].onmousemove = img[o].onmouseout = new Function("cl=false;obj[" + o + "].click()");
	img[o].onclick = new Function("cl=true;obj[" + o + "].click()");

	/* initial display */
	this.zoom();
}

/* mouse */
document.onmousemove = function(e)
{
	if ( ! e)
	{
		e = window.event;
	}
	xm = (e.x || e.clientX);
	ym = (e.y || e.clientY);
}

/* init */
function load()
{
	/* html elements */
	scr = document.getElementById("screen");
	spa = scr.getElementsByTagName("span");
	img = scr.getElementsByTagName("img");
	cap = document.getElementById("caption");
	
	/* mouseover border */ 
	document.getElementById("border").onmouseover = function()
	{
		cl = true;
		if(ob >= 0 && obj[ob].s > 0) obj[ob].click();
		ob = -1;
	}

	/* global variables */
	W = parseInt(scr.style.width);
	H = parseInt(scr.style.height);
	M = W / Mg;
	Sx = (W - (Nx - 1) * M) / Nx;
	Sy = (H - (Ny - 1) * M) / Ny;
	Wi = Tx * Sx + (Tx - 1) * M;
	Hi = Ty * Sy + (Ty - 1) * M;
	SP = M * Tx * SP;
	wi = (Wi - Sx) / SP;
	hi = (Hi - Sy) / SP;
	
	/* create objects */
	for (k = 0, i = 0; i < Nx; i ++)
	{
		for (j = 0; j < Ny; j ++)
		{
			obj[k] = new Cobj(k ++, i, j);
		}
	}
}
