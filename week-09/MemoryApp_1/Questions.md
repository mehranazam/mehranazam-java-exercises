#Questions from stand up

1. Configs via annotation & configs When to use either
2. XML familarity


#Some advantages of using XML configuration:

The XML configuration is at one place, instead of being scattered all over the source code in case of annotations. 
It takes a little more efforts to write XML config, but it saves a lot of time later when you search for dependencies and try to understand the project.
XML keeps configuration well organized and simple. Hence is easier to understand, it helps new relatively inexperienced team members get up to speed quickly.
Allows you to change the config without a need to recompile and redeploy code. So it is better, when it comes to production support.
So in short XML configuration takes a little more efforts, but it saves you a lot of time & headache later in big projects.

#2.5 years later (2017)

We use annotations mostly these days, but most crucial change is that we create many small projects (instead of a one big project). Hence understanding dependencies is not a problem anymore; as each project has it's unique purpose and relatively small codebase.
#Outcomes:
- ADD spring DI to the POM
- config the memory repo, service, view, controller comps to use xml
- run the app using ClassPathXmlApplicationContext