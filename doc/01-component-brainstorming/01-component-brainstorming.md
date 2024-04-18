# Portfolio Part 1: Component Brainstorming

- **Name**: Zeyad Mansour
- **Dot Number**: mansour.101
- **Due Date**: 02/16/24

## Assignment Overview

The overall goal of the portfolio project is to have you design and implement
your own OSU component. There are no limits to what you choose to design and
implement, but your component must fit within the constraints of our software
sequence discipline. In other words, the component must extend from Standard and
must include both a kernel and a secondary interface.

Because this is a daunting project, we will be providing you with a series of
activities to aid in your design decisions. For example, the point of this
assignment is to help you brainstorm a few possible components and get some
feedback. For each of these components, you will need to specify the high-level
design in terms of the software sequence discipline. In other words, you will
describe a component, select a few kernel methods for your component, and select
a few secondary methods to layer on top of your kernel methods.

You are not required to specify contracts at this time. However, you are welcome
to be as detailed as you'd like. More detail means you will be able to get more
detailed feedback, which may help you decide which component to ultimately
implement.

## Assignment Checklist

Because these documents are long and full of text, you will be supplied with
a quick overview of what you need to do to get the assignment done as follows:

### Getting Started Tasks

- [x] I have added my name to the top of this document
- [x] I have added my dot number to the top of this document
- [x] I have added the due date to the top of this document
- [x] I have read the assignment overview in the "Assignment Overview" section
- [x] I have read the assignment learning objectives in the "Assignment Learning Objectives" section
- [x] I have read the assignment rubric in the "Assignment Rubric" section
- [x] I have read this checklist

### Ongoing Tasks

- [x] I have shared my interests in the "Pre-Assignment" section
- [x] I have drafted my first component idea in the "Component Designs" section
- [x] I have drafted my second component idea in the "Component Designs" section
- [x] I have dradted my third component idea in the "Component Designs" section

### Submission Tasks

- [x] I have shared assignment feedback in the "Assignment Feedback" section
- [x] I have converted this document to a PDF
- [x] I am prepared to submit the PDF on Carmen
- [x] I am prepared to give my peers feedback on their ideas

## Assignment Learning Objectives

Without learning objectives, there really is no clear reason why a particular
assessment or activity exists. Therefore, to be completely transparent, here is
what we're hoping you will learn through this particular aspect of the portfolio
project. Specifically, students should be able to:

1. Integrate their areas of interest in their personal lives and/or careers with
   their knowledge of software design
2. Determine the achievablility of a software design given time constraints
3. Design high-level software components following the software sequence
   discipline

## Assignment Rubric: 10 Points

Again, to be completely transparent, most of the portfolio project, except the
final submission, is designed as a formative assessment. Formative assessments
are meant to provide ongoing feedback in the learning process. Therefore,
the rubric is designed to assess the learning objectives *directly* in a way
that is low stakes—meaning you shouldn't have to worry about the grade. Just
do good work.

1. (3 points) Each design must align with your personal values and long-term
   goals. Because the goal of this project is to help your build out a
   portfolio, you really ought to care about what you're designing. We'll give
   you a chance to share your personal values, interests, and long-term goals
   below.
2. (3 points) Each design must be achievable over the course of a single
   semester. Don't be afraid to design something very small. There is no shame
   in keeping it simple.
3. (4 points) Each design must fit within the software sequence discipline. In
   other words, your design should expect to inherit from Standard, and it
   should contain both kernel and secondary methods. Also, null and aliasing
   must be avoided, when possible. The methods themselves must also be in
   justifiable locations, such as kernel or secondary.

## Pre-Assignment

> Before you jump in, we want you to take a moment to share your interests
> below. Use this space to talk about your career goals as well as your personal
> hobbies. These will help you clarify your values before you start
> brainstorming. Plus it helps us get to know you better! Feel free to share
> images in this section.

I'm interested in artificial intelligence, particularly in the realm of computer vision. I aspire to become a software engineer or researcher at a big tech company. Some of my hobbies include running and rock climbing.

My personal website is [zeyadmansour.com](https://zeyadmansour.com)

## Assignment

As previously stated, you are tasked with brainstorming 3 possible components.
To aid you in this process, we have provided some example components that may
help you in your brainstorming. These components are organized by CSE
specializations.

- Artificial Intelligence
  - Artificial Neuron
  - Activation Function
  - Graphs
  - Search
- Computer Graphics and Game Design
  - Pixel
  - Polygon
  - Geometry
  - Pathing
- Database Systems and Data Analytics
  - Object Relational Mapping (ORM)
  - Any Data Model
  - Scraping
  - Data Mining
- Information and Computation Assurance
  - Password Hashing
- Computer Networking
  - Packet
  - MAC Address
  - IP Address
- Computer Systems
  - Complex Logic Gate
  - Semiconductor
- Software Engineering
  - Unit Testing
  - Performance Testing
- Individualized Option (e.g., X + CS)
  - Mathematical Matrix
  - Music Playlist

There is no requirement that you make use of any of the subdisciplines above.
If you want to model something from the real-world, go for it! Very common early
object projects usually attempt to model real-world systems like banks, cars,
etc. Make of this whatever seems interesting to you, and keep in mind that
you're just brainstorming right now. You do not have to commit to anything.

### Example Component

With all that in mind, here's an example component you can use for reference.
Feel free to use this example as the groundwork for your own components below.

- Example Component: `Point3D`
  - **Description**: The purpose of this component is to model a 3-dimensional point.
    Our intent with this design was to keep a simple kernel that provides getters and
    setters for the three underyling coordinates. Then, we provide more complex
    mathematical operations in the secondary interface. It might be possible to
    create an immutable version of the class by removing the setters and instead
    having all secondary methods return new points. However, this design seems more
    inline with NaturalNumber.
  - **Kernel Methods**:
    - `double getX()`: gets the x-coordinate of `this`
    - `double getY()`: gets the y-coordinate of `this`
    - `double getZ()`: gets the z-coordinate of `this`
    - `double setX(double x)`: sets the x-coordinate of `this`
    - `double setY(double y)`: sets the y-coordinate of `this`
    - `double setZ(double z)`: sets the z-coordinate of `this`
  - **Secondary Methods**:
    - `void translate(double x, double y, double z)`: moves `this` by translating
      each coordinate by `x`, `y`, and `z`, respectively
    - `void translate(Point3D p)`: moves `this` by treating `p` as a vector
    - `void move(double x, double y, double z)`: moves `this` by overwriting each
      coordinate with `x`, `y`, and `z`, respectively
    - `void move(Point3D p)`: moves `this` to `p`
    - `double distance(Point3D p)`: gives the distance between `this` and `p`
    - `Point3D vectorTo(Point3D p)`: gives the vector from `this` to `p`
    - `boolean isOrigin()`: returns `true` if all three coordinates are zero

Keep in mind that the general idea when putting together these layered designs
is to put the minimal implementation in the kernel. In this case, the kernel is
only responsible for giving back the coordinates of the point. The secondary
methods use these getters and setters to perform more complex operations like
translating the point or computing the distance between two points.

Also, keep in mind that we don't know the underlying implementation. It would be
completely reasonable to create a `Point3D1L` class which layers the kernel on
top of the existing `Point` class in Java. It would also be reasonable to
implement `Point3D2` on top of three doubles and `Point3D3` on top of an array.
Do not worry about your implementations at this time.

On top of everything above, there is no expectation that you have a perfect
design. Part of the goal of this project is to have you actually use your
component once it's implemented to do something interesting. At which point, you
will likely refine your design to make your implementation easier to use.

### Component Designs

> Please use this section to share your designs.

- Component Design #1: `SimpleArtificialNeuron`
  - **Description**: This component simulates a basic artificial neuron, which is the fundamental building block of artificial neural networks.
  - **Kernel Methods**:
    - `setWeights(double[] weights)`: Sets the weights of the neuron's inputs.
    - `setBias(double bias)`: Sets the bias of the neuron.
    - `activate(double[] inputs)`: Activates the neuron by applying a weighted sum of inputs and the bias, followed by an activation function.
  - **Secondary Methods**:
    - `applyActivationFunction(double netInput)`: Applies an activation function (e.g., sigmoid, ReLU) to the net input.
    - `calculateOutput(double[] inputs)`: Calculates the output of the neuron given input values.

- Component Design #2: `SimpleActivationFunction`
  - **Description**: This component provides implementations of common activation functions used in artificial neural networks.
  - **Kernel Methods**:
    - `sigmoid(double x)`: Computes the sigmoid activation function.
    - `relu(double x)`: Computes the ReLU (Rectified Linear Unit) activation function.
    - `tanh(double x)`: Computes the hyperbolic tangent activation function.
  - **Secondary Methods**:
    - `softmax(double[] inputs)`: Computes the softmax activation function for a vector of inputs.
    - `leakyReLU(double x, double alpha)`: Computes the Leaky ReLU activation function with a specified slope (alpha).
    - `elu(double x, double alpha)`: Computes the Exponential Linear Unit (ELU) activation function with a specified alpha parameter.

- Component Design #3: `SimpleImageFilter`
  - **Description**: This component aims to apply basic filters to images, suitable for beginners or simple image processing tasks.
  - **Kernel Methods**:
    - `loadImage(String path)`: Loads an image from the specified file path.
    - `saveImage(String path)`: Saves the current image to the specified file path.
  - **Secondary Methods**:
    - `applyGrayscale()`: Converts the image to grayscale.
    - `applyBlur(int radius)`: Applies a blur effect to the image with the given radius.
    - `applyThreshold(int threshold)`: Converts the image to binary using a specified threshold.
    - `applyFlip(boolean horizontal)`: Flips the image horizontally or vertically.

- Component Design #4:
  - **Description**: `UserAccount`
    - This component models a user account within a system, whether it's for a social media platform, an e-commerce website, or any other online service.
  - **Kernel Methods**:
    - `String getUsername()`: retrieves the username associated with the account
    - `String getEmail()`: retrieves the email address associated with the account
    - `void setUsername(String username)`: sets a new username for the account
    - `void setEmail(String email)`: sets a new email address for the account
  - **Secondary Methods**:
    - `boolean isLoggedIn()`: checks if the user is currently logged in
    - `void logout()`: logs out the user from the account
    - `void changePassword(String newPassword)`: changes the password for the account
    - `boolean verifyCredentials(String username, String password)`: verifies if the provided username and password match the account credentials
    - `void updateProfile(ProfileData newData)`: updates the profile information associated with the account

- Component Design #5:
  - **Description**: `InventoryItem`
    - This component represents an item within an inventory system, such as in a retail store, warehouse, or online marketplace.
  - **Kernel Methods**:
    - `String getName()`: retrieves the name of the inventory item
    - `double getPrice()`: retrieves the price of the inventory item
    - `int getQuantity()`: retrieves the quantity of the inventory item available
    - `void setPrice(double price)`: sets a new price for the inventory item
    - `void setQuantity(int quantity)`: sets a new quantity for the inventory item
  - **Secondary Methods**:
    - `void restock(int quantity)`: adds a specified quantity to the inventory item
    - `void sell(int quantity)`: reduces the quantity of the inventory item when sold
    - `double calculateTotalValue()`: calculates the total value of the inventory item based on price and quantity
    - `boolean isInStock()`: checks if the inventory item is currently in stock
    - `void updateInformation(ItemData newData)`: updates additional information associated with the inventory item, such as description or category

- Component Design #6:
  - **Description**: `TaskManager`
    - This component manages tasks or to-dos within a task management system, helping users organize and prioritize their activities.
  - **Kernel Methods**:
    - `List<Task> getTasks()`: retrieves the list of tasks managed by the task manager
    - `void addTask(Task newTask)`: adds a new task to the task manager
    - `void removeTask(Task task)`: removes a task from the task manager
  - **Secondary Methods**:
    - `void markAsCompleted(Task task)`: marks a task as completed within the task manager
    - `List<Task> getPriorityTasks()`: retrieves priority tasks from the task manager
    - `List<Task> getOverdueTasks()`: retrieves overdue tasks from the task manager
    - `void updateTask(Task task, TaskData newData)`: updates the information associated with a specific task
    - `List<Task> searchTasks(String keyword)`: searches for tasks containing a specific keyword within their 

## Post-Assignment

The following sections detail everything that you should do once you've
completed the assignment.

### Submission

If you have completed the assignment using this template, we recommend that
you convert it to a PDF before submission. If you're not sure how, check out
this [Markdown to PDF guide][markdown-to-pdf-guide]. However, PDFs should be
created for you automatically every time you save, so just double check that
all your work is there before submitting.

### Peer Review

Following the completion of this assignment, you will be assigned three
students' component brainstorming assignments for review. Your job during the
peer review process is to help your peers flesh out their designs. Specifically,
you should be helping them determine which of their designs would be most
practical to complete this semester. When reviewing your peers' assignments,
please treat them with respect. Note also that we can see your comments, which
could help your case if you're looking to become a grader. Ultimately, we
recommend using the following feedback rubric to ensure that your feedback is
both helpful and respectful (you may want to render the markdown as HTML or a
PDF to read this rubric as a table).

| Criteria of Constructive Feedback | Missing                                                                                                                           | Developing                                                                                                                                                                                                                                | Meeting                                                                                                                                                               |
| --------------------------------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Specific                          | All feedback is general (not specific)                                                                                            | Some (but not all) feedback is specific and some examples may be provided.                                                                                                                                                                | All feedback is specific, with examples provided where possible                                                                                                       |
| Actionable                        | None of the feedback provides actionable items or suggestions for improvement                                                     | Some feedback provides suggestions for improvement, while some do not                                                                                                                                                                     | All (or nearly all) feedback is actionable; most criticisms are followed by suggestions for improvement                                                               |
| Prioritized                       | Feedback provides only major or minor concerns, but not both. Major and minar concerns are not labeled or feedback is unorganized | Feedback provides both major and minor concerns, but it is not clear which is which and/or the feedback is not as well organized as it could be                                                                                           | Feedback clearly labels major and minor concerns. Feedback is organized in a way that allows the reader to easily understand which points to prioritize in a revision |
| Balanced                          | Feedback describes either strengths or areas of improvement, but not both                                                         | Feedback describes both strengths and areas for improvement, but it is more heavily weighted towards one or the other, and/or descusses both but does not clearly identify which part of the feedback is a strength/area for improvement  | Feedback provides balanced discussion of the document's strengths and areas for improvement. It is clear which piece of feedback is which                             |
| Tactful                           | Overall tone and language are not appropriate (e.g., not considerate, could be interpreted as personal criticism or attack)       | Overall feedback tone and language are general positive, tactul, and non-threatening, but one or more feedback comments could be interpretted as not tactful and/or feedback leans toward personal criticism, not focused on the document | Feedback tone and language are positive, tactful, and non-threatening. Feedback addesses the document, not the writer                                                 |

### Assignment Feedback

> Now that you've had a chance to complete the assignment, is there anything you
> would like to say about the assignment? For example, are there any resources
> that could help you complete this assignment? Feel free to use the feedback
> rubric above when reviewing this assignment.

Nothing comes to mind!

[markdown-to-pdf-guide]: https://therenegadecoder.com/blog/how-to-convert-markdown-to-a-pdf-3-quick-solutions/
