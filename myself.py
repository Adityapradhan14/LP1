import tkinter as tk

root=tk.Tk()
root.title("Registration Form")
root.geometry("500x500")
root.configure(bg="lightgreen")

entry_label=tk.Label(root,text="WELCOME TO FALCONS SPORTS CLUB",font=("Times",25,"bold"),bg="white",fg="red")
entry_label.pack(pady=20)

name_label=tk.Label(root,text="Name: ",font=("Arial",15,"bold"),bg="lightgreen",fg="black")
name_label.pack(pady=5)
name_entry=tk.Entry(root,width=30,font=("Arial",15))
name_entry.pack(pady=5)

age_label=tk.Label(root,text="Age: ",font=("Arial",15,"bold"),bg="lightgreen",fg="black")
age_label.pack(pady=5)
age_entry=tk.Entry(root,width=30,font=("Arial",15))
age_entry.pack(pady=5)

gender_label=tk.Label(root,text="Gender: ",font=("Arial",15,"bold"),bg="lightgreen",fg="black")
gender_label.pack(pady=5)
gender_type=tk.StringVar(value="Select")
gender_dropdown=tk.OptionMenu(root,gender_type,"Male","Female","Other")
gender_dropdown.config(width=20,font=("Arial", 12))
gender_dropdown.pack(pady=20)

phone_label=tk.Label(root,text="Phone Number: ",font=("Arial",15,"bold"),bg="lightgreen",fg="black")
phone_label.pack(pady=5)
phone_entry=tk.Entry(root,width=30,font=("Arial",15))
phone_entry.pack(pady=5)

sport_label=tk.Label(root,text="Enter the sport you want to enroll",font=("Arial",15,"bold"),bg="lightgreen",fg="black")
sport_label.pack(pady=5)
sport_type=tk.StringVar(value="Select")
sport_dropdown=tk.OptionMenu(root,sport_type,"Cricket","Football","Badminton","Swimming","Tennis")
sport_dropdown.config(width=20,font=("Arial", 12))
sport_dropdown.pack(pady=20)


# Frame for checkboxes
checkbox_frame = tk.Frame(root, bg="lightgreen")
checkbox_frame.pack(pady=10)

# Label for checkboxes
time_label = tk.Label(checkbox_frame, text="Choose your availability:", font=("Arial", 15, "bold"), bg="white", fg="black")
time_label.pack(anchor="w")

# Independent variables for each checkbox
one_hour_var = tk.IntVar()
one_to_two_var = tk.IntVar()
two_to_three_var = tk.IntVar()
three_to_four_var = tk.IntVar()
more_than_four_var = tk.IntVar()

# Checkbuttons with individual variables
one_hour_cb = tk.Checkbutton(checkbox_frame, text="1 hour", variable=one_hour_var, font=("Arial", 12), bg="lightgreen")
one_hour_cb.pack(anchor="w")
one_to_two_cb = tk.Checkbutton(checkbox_frame, text="1 to 2 hours", variable=one_to_two_var, font=("Arial", 12), bg="lightgreen")
one_to_two_cb.pack(anchor="w")
two_to_three_cb = tk.Checkbutton(checkbox_frame, text="2 to 3 hours", variable=two_to_three_var, font=("Arial", 12), bg="lightgreen")
two_to_three_cb.pack(anchor="w")
three_to_four_cb = tk.Checkbutton(checkbox_frame, text="3 to 4 hours", variable=three_to_four_var, font=("Arial", 12), bg="lightgreen")
three_to_four_cb.pack(anchor="w")
more_than_four_cb = tk.Checkbutton(checkbox_frame, text="More than 4 hours", variable=more_than_four_var, font=("Arial", 12), bg="lightgreen")
more_than_four_cb.pack(anchor="w")


proceed_button=tk.Button(root,text="Proceed",font=("Arial",15,"bold"),bg="pink",fg="black")
proceed_button.pack(pady=5)

tagline_label=tk.Label(root,text="skill up stand out succeed",font=("Verdana",20,"italic"),bg="lightgreen",fg="black")
tagline_label.pack(side="bottom",pady=5)


root.mainloop()
