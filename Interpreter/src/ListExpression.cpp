/*
 * fuzuli : A general purpose interpreter
 * Copyright (C) 2012 Mehmet Hakan Satman <mhsatman@yahoo.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

#include "../include/FuzuliTypes.h"
#include <cstdlib>
#include <cstring>
#include <vector>

namespace fuzuli {

using namespace std;

ListExpression::ListExpression(vector<Expression*> expr) {
	this->expressions = expr;
}

ListExpression::~ListExpression() {
	// TODO Auto-generated destructor stub
}

Token *ListExpression::eval(Environment *env){
	Token *result = new Token("@FuzuliList",LIST);
	for (unsigned int i=0;i<this->expressions.size();i++){
		Token *temp = this->expressions[i]->eval(env);
		if(temp->getType() == BREAKTOKEN) {
			break;
		}
		result->tokens.push_back(temp);
	}
	return(result);
}





/************************/
/* Other List Functions */
/************************/

/************************/
/* Length 				*/
/************************/
LengthExpression::LengthExpression(vector<Expression*> expr) {
	this->expressions = expr;
}

LengthExpression::~LengthExpression() {
	// TODO Auto-generated destructor stub
}

Token *LengthExpression::eval(Environment *env){
	Token *tok = this->expressions[0]->eval(env);
	Token *result = new Token(0.0, INTEGER);
	result->setIntValue(tok->tokens.size());
	return(result);
}



/************************/
/* Nth */
/************************/
NthExpression::NthExpression(vector<Expression*> expr) {
	this->expressions = expr;
}

NthExpression::~NthExpression() {
	// TODO Auto-generated destructor stub
}

Token *NthExpression::eval(Environment *env){
	Token *list = this->expressions[0]->eval(env);
	if(list==NULL){
		cout << "FuzuliList is NULL in nth" <<endl;
		exit(-3);
	}
	Token *n = this->expressions[1]->eval(env);
	if( ((unsigned int)n->getIntValue()) >= list->tokens.size()){
		cout << "List index out of bounds of "<< n->getContent()<<endl;
		exit(-3);
	}
	Token *result = list->tokens[n->getIntValue()];
	if(result==NULL){
		result = Token::NULL_TOKEN;
	}
	return(result);
}




/************************/
/* Set 					*/
/************************/
SetExpression::SetExpression(vector<Expression*> expr) {
	this->expressions = expr;
}

SetExpression::~SetExpression() {
	// TODO Auto-generated destructor stub
}

Token *SetExpression::eval(Environment *env){
	Token *list = this->expressions[0]->eval(env);  /* list name*/
	Token *n = this->expressions[1]->eval(env);		/* n */
	list->tokens[n->getIntValue()] = this->expressions[2]->eval(env);
	return(list->tokens[n->getIntValue()]);
}


/************************/
/* Explode				*/
/************************/
ExplodeExpression::ExplodeExpression(vector<Expression*> expr){
	this->expressions = expr;
	this->resultToken = new Token("@FuzuliList", LIST);
}

ExplodeExpression::~ExplodeExpression(){

}

Token *ExplodeExpression::eval(Environment *env){
	Token *source_str = this->expressions[0]->eval(env);
	Token *delim = this->expressions[1]->eval(env);
	this->resultToken->tokens.clear();

	char *temp = (char*)malloc(strlen(source_str->getContent()));
	strcpy(temp, source_str->getContent());

	char *p = strtok(temp, delim->getContent());
	while(p){
		Token *tok = new Token(p, STRING);
		this->resultToken->tokens.push_back(tok);
		p = strtok (NULL, delim->getContent());
	}

	free(temp);
	return(this->resultToken);
}



ColonExpression::ColonExpression(vector<Expression*> expr){
	this->expressions = expr;
}

ColonExpression::~ColonExpression(){
	cout << "ColonExpression Destructor"<<endl;
}

Token *ColonExpression::eval(Environment *env){
	Token *num1 = this->expressions[0]->eval(env);
	Token *num2 = this->expressions[1]->eval(env);
	Token *result = new Token("@FuzuliList", LIST);
	for (int i=num1->getIntValue(); i<=num2->getIntValue(); i++){
		Token *tok = new Token(i, FLOAT);
		result->tokens.push_back(tok);
		Environment::garbage.push_back(tok);
	}
	return(result);
}



AppendExpression::AppendExpression(vector<Expression*> expr) {
	this->expressions = expr;
}

AppendExpression::~AppendExpression() {
	// TODO Auto-generated destructor stub
}

Token *AppendExpression::eval(Environment *env){
	Token *list = this->expressions[0]->eval(env);  /* list name*/
	Token *element = this->expressions[1]->eval(env);
	list->tokens.push_back(element);
	return(list);
}


PrependExpression::PrependExpression(vector<Expression*> expr) {
	this->expressions = expr;
}

PrependExpression::~PrependExpression() {
	// TODO Auto-generated destructor stub
}

Token *PrependExpression::eval(Environment *env){
	Token *list = this->expressions[0]->eval(env);  /* list name*/
	Token *element = this->expressions[1]->eval(env);
	list->tokens.insert(list->tokens.begin(), element);
	return(list);
}

RemoveExpression::RemoveExpression(vector<Expression*> expr){
	this->expressions = expr;
}

RemoveExpression::~RemoveExpression(){

}

Token *RemoveExpression::eval(Environment *env){
	Token *arr = this->expressions[0]->eval(env);
	Token *n = this->expressions[1]->eval(env);
	arr->tokens.erase( arr->tokens.begin() + n->getIntValue());
	return(arr);
}


FindExpression::FindExpression(vector<Expression*> expr){
	this->expressions = expr;
}

FindExpression::~FindExpression(){

}

Token *FindExpression::eval(Environment *env){
	Token *arr = this->expressions[0]->eval(env);
	Token *what = this->expressions[1]->eval(env);
	for (unsigned int i=0;i<arr->tokens.size();i++){
		if(arr->tokens[i]->Equal(what)){
			return(new Token(i, INTEGER));
		}
	}
	return(Token::NULL_TOKEN);
}


} /* namespace fuzuli */
