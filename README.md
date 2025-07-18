# J-HED

J-HED is a library that aims to reinforce simplicity and
performance in the world of templating, which does have a
lot of unnecessary complexity to do one simple task:
generate html before the web-page runtime. Perceive
that it doesn't apply any rules about how it should be
done by itself, it just says what goals we should be
looking for. Taking this into consideration, a question
may arise: "What is the point of giving a simple task a
so convoluted solution, which separates things in its own
opinionated way and give it extra steps (which only increases
the overhead of a so trivial assignment), to do something
like this?", and the answer is simple, it's _overengineering_
disguised as organization and a necessary separation of concerns,
and the objective of this library is to give the developer
the freedom to choose its own rules, when it comes to perform
that task, just like a real library.

## Why use this library?
Well..., there are some advantages and disadvantages you should
leverage into consideration before using this library, like
everything in programming, and some are:
> ### advantages:
> 1. type safety
> 2. low overhead
> 3. high performance
> 4. both declarative and imperative ways of composing
> 5. ease of use
> ### disadvantages
> 1. few functionalities
> 2. not pre-organized
> 3. not well-supported by other tools/versions
## How to use this library?
The answer is simple, just _use your editor autocompletion_.
Well this may look a bit arrogant, but that is another goal
of this library, not just be simple by having clear
responsibilities, but by also being clear on how things works
and should be taken into account to do its well pre-defined
task. So to give you a cleaner example, there is a simple piece
of code where this library is being used:

```java
import migke.jhed.attributes.enums.Dir;
import migke.jhed.elements.types.TagType;

import static migke.jhed.JHed.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                build().pipe((b) ->
                        b.html(() -> {
                            b.head(() -> {
                                b.title(() -> b.text("Home Page"));
                                b.style(() -> b.text("""
                                            * {
                                                margin: 0;
                                                padding: 0;
                                            }
                                        """));
                            });
                            b.body(() -> b.h1(attrs(TagType.H1.class).withDir(Dir.RTL), () -> b.text("Home Page"))
                            );
                        })
                ).createRenderer().render()
        );
    }
}
```

Ok, that may be not a so good of a first impression..., so there
is the same example but more organized:

```java
import migke.jhed.attributes.enums.Dir;
import migke.jhed.elements.types.TagType;

import static migke.jhed.JHed.*;

public class Main {
    public static void main(String[] args) {
        var b = build();
        b.html(() -> {
            b.head(() -> {
                b.title(() -> b.text("Home Page"));
                b.style(() -> b.text("""
                                    * {
                                        margin: 0;
                                        padding: 0;
                                    }
                        """));
            });
            b.body(() -> b.h1(
                            attrs(TagType.H1.class).withDir(Dir.RTL),
                            () -> b.text("Home Page")
                    )
            );
        });
        var renderer = b.createRenderer();
        System.out.println(renderer.render());
    }
}
```

now a shorter one?

```java
import static migke.jhed.JHed.*;

public static void main(String[] args) {
    var renderer = build()
            .pipe(
                    // escaped for safety...
                    (b) -> b.text("<input type='number'>"),
                    // :)
                    (b) -> b.text("hello"),
                    (b) -> b.text(" world!"),
                    (b) -> b.text("i am not displayed :D")
            )
            .createRenderer();
    System.out.println(renderer.render(0, 1, 2));
}
```

now as you can probably see, this library is very easy to use
and can be composed in many ways.