const preloadMovies = [
    {
        "title" : "Puss in Boots: The Last Wish",
        "category" : "ADVENTURE",
        "rating" : "PG",
        "director" : "Joel Crawford",
        "producer" : "Paul Fisher",
        "cast" : "Antonio Banderas, Salma Hayek, Florence Pugh, Olivia Colman",
        "releaseDate" : "12/21/2022",
        "synopsis" : "Puss in Boots discovers that his passion for adventure has taken its toll: He has burned through eight of his nine lives, leaving him with only one life left. Puss sets out on an epic journey to find the mythical Last Wish and restore his nine lives.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1NqwE6LP9IEdOZ57NCT51ftHtWT.jpg",
        "trailerURL" : "https://www.youtube.com/embed/xgZLXyqbYOc"
    },
    {
        "title" : "The Whale",
        "category" : "DRAMA",
        "rating" : "R",
        "director" : "Darren Aronofsky",
        "producer" : "Samuel D. Hunter",
        "cast" : "Brendan Fraser, Sadie Sink, Hong Chau",
        "releaseDate" : "12/09/2022",
        "synopsis" : "A reclusive English teacher suffering from severe obesity attempts to reconnect with his estranged teenage daughter for one last chance at redemption.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tuM7fBS8o5oQbtUEwdCNY3SqnRb.jpg",
        "trailerURL" : "https://www.youtube.com/embed/D30r0CwtIKc"
    },
    {
        "title" : "Avatar: The Way of Water",
        "category" : "SCIENCE_FICTION",
        "rating" : "PG-13",
        "director" : "James Cameron",
        "producer" : "Amanda Silver",
        "cast" : "Sam Worthington, Zoe Saldaña, Sigourney Weaver, Stephen Lang",
        "releaseDate" : "12/16/2022",
        "synopsis" : "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
        "trailerURL" : "https://www.youtube.com/embed/a8Gx8wiNbs8"
    },
    {
        "title" : "Guardians of the Galaxy Volume 3",
        "category" : "SCIENCE_FICTION",
        "rating" : "PG-13",
        "director" : "James Gunn",
        "producer" : "Steve Englehart",
        "cast" : "Chris Pratt, Zoe Saldaña, Dave Bautista, Karen Gillan",
        "releaseDate" : "05/05/2023",
        "synopsis" : "After acquiring Knowhere from the Collector, we find the Guardians working to repair the extreme damage done by Thanos-determined to make Knowhere a safe haven, not only for themselves, but for all refugees displaced by the harsh universe. It isn't long before their attempt to return to normal is upended by a brutal attack from a new unknown enemy, and Peter, still reeling from the loss of Gamora, must rally his team around him to defend the universe along with protecting one of their own. A mission, if not completed successfully, could quite possibly lead to the end of the Guardians as we know them.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ok4JTPFXGvj81wXK4pHvifCgI9x.jpg",
        "trailerURL" : "https://www.youtube.com/embed/u3V5KDHRQvk"
    },
    {
        "title" : "Spider-Man: Across the Spider-Verse",
        "category" : "ACTION",
        "rating" : "PG-13",
        "director" : "Joaquim Dos Santos",
        "producer" : "Phil Lord",
        "cast" : "Shameik Moore, Oscar Isaac, Hailee Steinfeld, Jake Johnson",
        "releaseDate" : "06/02/2023",
        "synopsis" : "Miles Morales returns for the next chapter of the Spider-Verse saga, an epic adventure that will transport Brooklyn’s full-time, friendly neighborhood Spider-Man across the Multiverse to join forces with Gwen Stacy and a new team of Spider-People to face off with a villain more powerful than anything they have ever encountered.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7g4J08JRBGsYr7N7OYPMYYMKIbG.jpg",
        "trailerURL" : "https://www.youtube.com/embed/BbXJ3_AQE_o"
    },
    {
        "title" : "Empire of Light",
        "category" : "ROMANCE",
        "rating" : "R",
        "director" : "Sam Mendes",
        "producer" : "Sam Mendes",
        "cast" : "Olivia Colman, Micheal Ward, Toby Jones",
        "releaseDate" : "12/09/2022",
        "synopsis" : "A love story set in and around an old cinema on the South Coast of England in the 1980s.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8Ji1h0nZB1fmimAalfi97fnKfXg.jpg",
        "trailerURL" : "https://www.youtube.com/embed/HdMPTgYi-0w"
    },
    {
        "title" : "Spoiler Alert",
        "category" : "COMEDY",
        "rating" : "PG-13",
        "director" : "Michael Showalter",
        "producer" : "David Marshall Grant",
        "cast" : "Jim Parsons, Ben Aldridge, Sally Field",
        "releaseDate" : "12/16/2022",
        "synopsis" : "Journalist Michael Ausiello embarks on a rollercoaster ride of emotions when Kit Cowan,his partner of 14 years, is diagnosed with terminal cancer.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zdXoC9hgPieyT2x3TXcZGeRbpJZ.jpg",
        "trailerURL" : "https://www.youtube.com/embed/G9qIwkAi_Zk"
    },
    {
        "title" : "I Wanna Dance with Somebody",
        "category" : "DRAMA",
        "rating" : "PG-13",
        "director" : "Kasi Lemmons",
        "producer" : "Anthony McCarten",
        "cast" : "Naomi Ackie, Ashton Sanders, Stanley Tucci",
        "releaseDate" : "12/21/2022",
        "synopsis" : "The joyous, emotional, heartbreaking celebration of the life and music of Whitney Houston, the greatest female R&B pop vocalist of all time. Tracking her journey from obscurity to musical superstardom.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/szE2ACOGhdPYsulesKSQfhS4lBt.jpg",
        "trailerURL" : "https://www.youtube.com/embed/9tfemzaMkoU"
    },
    {
        "title" : "Babylon",
        "category" : "DRAMA",
        "rating" : "R",
        "director" : "Damien Chazelle",
        "producer" : "Damien Chazelle",
        "cast" : "Diego Calva, Margot Robbie, Brad Pitt, Jovan Adepo",
        "releaseDate" : "12/23/2022",
        "synopsis" : "A tale of outsized ambition and outrageous excess, tracing the rise and fall of multiple characters during an era of unbridled decadence and depravity in early Hollywood.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wjOHjWCUE0YzDiEzKv8AfqHj3ir.jpg",
        "trailerURL" : "https://www.youtube.com/embed/t7HT83wkVss"
    },
    {
        "title" : "Everything Everywhere All at Once",
        "category" : "ACTION",
        "rating" : "R",
        "director" : "Daniel Scheinert",
        "producer" : "Daniel Kwan",
        "cast" : "Michelle Yeoh, Ke Huy Quan, Stephanie Hsu, James Hong",
        "releaseDate" : "04/08/2022",
        "synopsis" : "An aging Chinese immigrant is swept up in an insane adventure, where she alone can save what's important to her by connecting with the lives she could have led in other universes.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/w3LxiVYdWWRvEVdn5RYq6jIqkb1.jpg",
        "trailerURL" : "https://www.youtube.com/embed/wxN1T1uxQ2g"
    },
    {
        "title" : "The Fabelmans",
        "category" : "COMEDY",
        "rating" : "PG-13",
        "director" : "Steven Spielberg",
        "producer" : "Tony Kushner",
        "cast" : "Gabriel LaBelle, Michelle Williams, Paul Dano, Seth Rogen",
        "releaseDate" : "11/23/2022",
        "synopsis" : "A coming-of-age story about a young man’s discovery of a shattering family secret and an exploration of the power of movies to help us see the truth about each other and ourselves.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/d2IywyOPS78vEnJvwVqkVRTiNC1.jpg",
        "trailerURL" : "https://www.youtube.com/embed/D1G2iLSzOe8"
    },
    {
        "title" : "Guillermo del Toro's Pinocchio",
        "category" : "DRAMA",
        "rating" : "PG",
        "director" : "Guillermo del Toro",
        "producer" : "Patrick McHale",
        "cast" : "Ewan McGregor, David Bradley, Christoph Waltz, Gregory Mann",
        "releaseDate" : "11/17/2022",
        "synopsis" : "During the rise of fascism in Mussolini's Italy, a wooden boy brought magically to life struggles to live up to his father's expectations.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vx1u0uwxdlhV2MUzj4VlcMB0N6m.jpg",
        "trailerURL" : "https://www.youtube.com/embed/Od2NW1sfRdA"
    },
    {
        "title" : "Prey for the Devil",
        "category" : "HORROR",
        "rating" : "PG-13",
        "director" : "Daniel Stamm",
        "producer" : "Robert Zappia",
        "cast" : "Jacqueline Byers, Colin Salmon, Christian Navarro, Lisa Palfrey",
        "releaseDate" : "10/28/2022",
        "synopsis" : "In response to a global rise in demonic possessions, the Catholic Church reopens exorcism schools to train priests in the Rite of Exorcism. On this spiritual battlefield, an unlikely warrior rises: a young nun, Sister Ann. Thrust onto the spiritual frontline with fellow student Father Dante, Sister Ann finds herself in a battle for the soul of a young girl and soon realizes the Devil has her right where he wants her.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/w3s6XEDNVGq5LUlghqs6VlvsvL6.jpg",
        "trailerURL" : "https://www.youtube.com/embed/u_jJiZ2oZgs"
    },
    {
        "title" : "Violent Night",
        "category" : "ACTION",
        "rating" : "R",
        "director" : "Tommy Wirkola",
        "producer" : "Patrick Casey",
        "cast" : "David Harbour, John Leguizamo, Beverly D'Angelo, Alex Hassell",
        "releaseDate" : "12/02/2022",
        "synopsis" : "When a team of mercenaries breaks into a wealthy family compound on Christmas Eve, taking everyone inside hostage, the team isn’t prepared for a surprise combatant: Santa Claus is on the grounds, and he’s about to show why this Nick is no saint.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1CHp8QQjGwqWaPZWjzcRidlt5Xs.jpg",
        "trailerURL" : "https://www.youtube.com/embed/a53e4HHnx_s"
    },
    {
        "title" : "Strange World",
        "category" : "ADVENTURE",
        "rating" : "PG",
        "director" : "Don Hall",
        "producer" : "Qui Nguyen",
        "cast" : "Jake Gyllenhaal, Dennis Quaid, Jaboukie Young-White, Gabrielle Union",
        "releaseDate" : "11/23/2022",
        "synopsis" : "A journey deep into an uncharted and treacherous land, where fantastical creatures await the legendary Clades—a family of explorers whose differences threaten to topple their latest, and by far most crucial, mission.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4H7dRko04LGUaDLHiVwSh4gv61S.jpg",
        "trailerURL" : "https://www.youtube.com/embed/5lR0pkUjzb4"
    },
    {
        "title" : "One Piece Film Red",
        "category" : "ADVENTURE",
        "rating" : "PG-13",
        "director" : "Goro Taniguchi",
        "producer" : "Tsutomu Kuroiwa",
        "cast" : "Kaori Nazuka, Ado, Shuichi Ikeda, Mayumi Tanaka, Kazuya Nakai",
        "releaseDate" : "11/04/2022",
        "synopsis" : "Uta — the most beloved singer in the world. Her voice, which she sings with while concealing her true identity, has been described as “otherworldly.” She will appear in public for the first time at a live concert. As the venue fills with all kinds of Uta fans — excited pirates, the Navy watching closely, and the Straw Hats led by Luffy who simply came to enjoy her sonorous performance — the voice that the whole world has been waiting for is about to resound.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/m80kPdrmmtEh9wlLroCp0bwUGH0.jpg",
        "trailerURL" : "https://www.youtube.com/embed/89JWRYEIG-s"
    },
    {
        "title" : "The Menu",
        "category" : "COMEDY",
        "rating" : "R",
        "director" : "Mark Mylod",
        "producer" : "Will Tracy",
        "cast" : "Ralph Fiennes, Anya Taylor-Joy, Nicholas Hoult",
        "releaseDate" : "11/18/2022",
        "synopsis" : "A couple travels to a coastal island to eat at an exclusive restaurant where the chef has prepared a lavish menu, with some shocking surprises.",
        "posterURL" : "",
        "trailerURL" : ""
    },
    {
        "title" : "Top Gun: Maverick",
        "category" : "ACTION",
        "rating" : "PG-13",
        "director" : "Joseph Kosinski",
        "producer" : "Ehren Kruger",
        "cast" : "Tom Cruise, Miles Teller, Jennifer Connelly",
        "releaseDate" : "05/27/2022",
        "synopsis" : "After more than thirty years of service as one of the Navy’s top aviators, and dodging the advancement in rank that would ground him, Pete “Maverick” Mitchell finds himself training a detachment of TOP GUN graduates for a specialized mission the likes of which no living pilot has ever seen.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/62HCnUTziyWcpDaBO2i1DX17ljH.jpg",
        "trailerURL" : "https://www.youtube.com/embed/qSqVVswa420"
    },
    {
        "title" : "Black Panther: Wakanda Forever",
        "category" : "ACTION",
        "rating" : "PG-13",
        "director" : "Ryan Coogler",
        "producer" : "Joe Robert Cole",
        "cast" : "Letitia Wright, Lupita Nyong'o, Danai Gurira, Angela Bassett",
        "releaseDate" : "11/11/2022",
        "synopsis" : "Queen Ramonda, Shuri, M’Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T’Challa’s death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.",
        "posterURL" : "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ps2oKfhY6DL3alynlSqY97gHSsg.jpg",
        "trailerURL" : "https://www.youtube.com/embed/RlOB3UALvrQ"
    },
]

export default preloadMovies