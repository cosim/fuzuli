#include <FuzuliTypes.h>
#include <iostream>
#include <Fl.H>
#include <Fl_Window.H>
#include <Fl_Button.H>
#include <Fl_Widget.H>
#include <Fl_Input.H>
#include <Fl_Progress.H>
#include <Fl_Dial.H>

namespace fuzuli {


class FuzuliWidgetInfo {
public:
	Environment *environment;
	string ftype;
};

class FuzuliWidget: public FuzuliWidgetInfo, public Fl_Widget {
public:
	FuzuliWidget(int x, int y, int width, int height, const char *t,
			Environment *env) : Fl_Widget(x,y,width,height,t) {
		this->environment = env;
		this->ftype = string("Widget");
	};

};


class FuzuliButton: public FuzuliWidgetInfo, public Fl_Button {
public:
	FuzuliButton(int x, int y, int width, int height, const char *t,
			Environment *env) : Fl_Button(x, y, width, height, t) {
		this->environment = env;
		this->ftype = string("Button");
	};
};


class FuzuliInput: public FuzuliWidgetInfo, public Fl_Input {
public:
	FuzuliInput(int x, int y, int width, int height, const char *t,
			Environment *env) : Fl_Input(x, y, width, height, t) {
		this->environment = env;
		this->ftype = string("Input");
	};
};

class FuzuliProgress: public FuzuliWidgetInfo, public Fl_Progress {
public:
	FuzuliProgress(int x, int y, int width, int height, const char *t,
			Environment *env) : Fl_Progress(x,y,width,height,t){
		this->environment = env;
		this->ftype = string("Progress");
	};
};


class FuzuliDial: public FuzuliWidgetInfo, public Fl_Dial {
public:
	FuzuliDial(int x, int y, int width, int height, const char *t,
			Environment *env) : Fl_Dial(x,y,width,height,t){
		this->environment = env;
		this->ftype = string("Dial");
	};
};

class FuzuliWindow: public FuzuliWidgetInfo, public Fl_Window {
public:
	FuzuliWindow(int x, int y, int width, int height, const char *t,
			Environment *env) :
			Fl_Window(x, y, width, height, t) {
		this->environment = env;
		this->ftype = string("Window");
	};
	FuzuliWindow(int w, int h, const char *title, Environment *env) :
			Fl_Window(w, h, title) {
		this->environment = env;
		this->ftype = string("Window");
	}
};


};
