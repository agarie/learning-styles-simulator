This project is the simulator used in the paper by [Dr. Fabiano Dorça](http://www.facom.ufu.br/~fabiano/):

*[A new approach to discover students learning styles in adaptive educational systems](http://www.br-ie.org/pub/index.php/rbie/article/download/1434/2121)*

This project provides a simulator for the evaluation of learning styles
strategies. At the moment, it implements only two: markov models and genetic
algorithms.

I'm currently refactoring the code, so everything should be counted as Dr.
Fabiano and his team's code, not mine.

## Installing

You'll need Java (duh) and `ant` to build and run the project:

    $ ant # Create build/ and dist/ directories.
    $ java -jar dist/*.jar # Run project.

Another possibility is to open the project on NetBeans, as it was originally
intended. I might remove the `nbproject/` directory in the future, but it'll
stay in place for some time.

## Usage

Working on it. It'll probably be some Simulator class that you can instantiate,
configure and run -- I'm still unsure about how to return the simulated values.

## Contributing

The general fork, edit & send a pull request cycle is fine:

1. Fork on GitHub.
2. Clone your repository locally via `$ git clone <your repo URL>`.
3. Make changes to the code. Ideally, you should create a new branch via `$ git checkout -b <branch name>`.
4. Push the changes to your repository with `$ git push`.
5. There should be a link to open a pull request in your repository.

[This guide](https://help.github.com/articles/fork-a-repo) by GitHub shows how
to do most of these steps. There's [another
one](https://guides.github.com/activities/contributing-to-open-source/) that
explains how contributing to open source works in general ways.

If you have doubts or suggestions, open an issue. In case you aren't
accostumed to contributing via GitHub, you can send me an e-mail with your
patch.

## License

As already said, most of the work was done by [Dr. Fabiano Dorça](http://www.facom.ufu.br/~fabiano/) and his team.

MIT License

Copyright (c) 2014 Dr. Fabiano Dorça <fabiano@facom.ufu.br>, Carlos Agarie <carlos@geekie.com.br>

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
