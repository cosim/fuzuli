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

#include <FuzuliTypes.h>
#include "FuzuliRunnable.h"
#include <boost/thread.hpp>

using namespace std;
using namespace fuzuli;

extern "C" {
	Token *thread (Token *p, Environment *env);
	Token *yield (Token *p, Environment *env);
	Token *join (Token *p, Environment *env);
}

Token *join (Token *p, Environment *env){
	FuzuliRunnable *run = (FuzuliRunnable*)p->tokens[0]->object;
	run->run();
	return(Token::NULL_TOKEN);
}

Token *yield (Token *p, Environment *env){
	//FuzuliRunnable *run = (FuzuliRunnable*)p->tokens[0]->object;
	//run->t.yield();
	boost::this_thread::yield();
	return(Token::NULL_TOKEN);
}

Token *thread (Token *p, Environment *env){
	FuzuliRunnable *run = new FuzuliRunnable();
	run->env =  env;
	cout << "Creating thread "<<endl;
	run->CreateThread(p->tokens[0]->getContent(), env);
	cout << "Created "<<endl;

	Token *result = env->newToken("@FuzuliRunnable", COBJECT);
	result->object = run;
	return(result);
}




